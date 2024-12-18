package modle;

import view.BackgroundImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class Obstacle {
    public int x,y;
    public BufferedImage image;
    private BufferedImage stone;
    private BufferedImage cacti;
    private int speed;
    public Obstacle(){
        try{
            stone= ImageIO.read(new File("image/石头.png"));
            cacti=ImageIO.read(new File("image/仙人掌.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        Random r = new Random();
        if(r.nextInt(2)==0){
            image=cacti;
        }else{
            image=stone;
        }
        x=800;
        y=150;
        speed= BackgroundImage.SPEED;
    }
    public void move(){
        x-=speed;
    }
    public boolean isLive(){
        if(x<=-image.getWidth()){
            return false;
        }
        return true;
    }
    public Rectangle getBounds(){
        if(image==cacti){
            return new Rectangle(x+40,y+14,25,75);
        }
        return new Rectangle(x+28,y+31,50,50);
    }
}

