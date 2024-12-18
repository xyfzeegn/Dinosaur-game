package modle;

import service.FreshThread;
import service.Sound;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Dinosaur {
    public BufferedImage image;
    private BufferedImage image1,image2,image3;
    public int x,y;
    private int jumpValue=0;
    private boolean jumpState=false;
    private int stepTimer=0;
    private final int JUMP_HIGHT =120;
    private final int LOWEST_Y=160;
    private final int FREASH= FreshThread.FREASH;
    public Dinosaur(){
        x=50;
        y=LOWEST_Y;
        try{
            image1= ImageIO.read(new File("image/恐龙1.png"));
            image2= ImageIO.read(new File("image/恐龙2.png"));
            image3= ImageIO.read(new File("image/恐龙3.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void step(){
        int tmp=stepTimer/250%3;
        switch (tmp){
            case 1:
                image=image1;
                break;
            case 2:
                image=image2;
                break;
            default:
                image=image3;
        }
        stepTimer+=FREASH;
    }
    public void jump(){
        if(!jumpState){
            Sound.jump();
        }
        jumpState=true;
    }
    public void move(){
        step();
        if(jumpState){
            if(y>=LOWEST_Y){
                jumpValue=-4;
            }
            if(y<=LOWEST_Y-JUMP_HIGHT){
                jumpValue=4;
            }
            y+=jumpValue;
            if(y>=LOWEST_Y){
                jumpState=false;
            }
        }
    }
    public Rectangle getFootBounds(){
        return new Rectangle(x+34,y+52,20,20);
    }
    public Rectangle getHeadBounds(){
        return new Rectangle(x+40,y+8,45,20);
    }

}

