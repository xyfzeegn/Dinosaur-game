package service;

import jdk.dynalink.beans.StaticClass;

import java.io.FileNotFoundException;

public class Sound {
    static final String DIR="music/";
    static final String BACKGROUND="background.wav";
    static final String JUMP="jump.wav";
    static final String HIT="hit.wav";

    private static void play(String file,boolean circulate){
        try{
            MusicPlayer player=new MusicPlayer(file,circulate);
            player.play();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    static public void jump(){
        play(DIR+JUMP,false);
    }
    static public void hit(){
        play(DIR+HIT,false);
    }
    static public void background(){
        play(DIR+BACKGROUND,false);
    }
}
