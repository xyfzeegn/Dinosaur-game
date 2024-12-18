package service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MusicPlayer implements Runnable {
    File soundFile;
    Thread thread;
    boolean circulate;
    public MusicPlayer(String filepath,boolean circulate)
            throws FileNotFoundException{
        this.circulate=circulate;
        soundFile=new File(filepath);
        if(!soundFile.exists()){
            throw new FileNotFoundException(filepath+"not found");
        }
    }
    public void run(){
        do{
            try{
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            }
        }while (circulate);
    }
    public void play(){
        thread=new Thread(this);
        thread.start();
    }
    public void stop(){
        thread.stop();
    }
}


