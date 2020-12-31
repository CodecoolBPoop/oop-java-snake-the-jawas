package com.codecool.snake.sound;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {

    static Clip music;
    static Clip soundLoop;

    public static Clip getMusic(String pathname) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(pathname));
            music = AudioSystem.getClip();
            music.open(audioInputStream);

        } catch(Exception ex) {
            System.out.println("Error with playing music.");
            ex.printStackTrace();
        }
        return music;
    }

    public static void startMusic(String pathname){
        music = getMusic(pathname);
        music.start();
        music.loop(-1);
    }

    public static void stopMusic(){
        music.stop();
    }


    public static void playSound(String pathname) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(pathname));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public static void startMusicWithDelay(String pathname, int after) {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(after),
                ae -> startMusic(pathname)));
        timeline.play();
    }

    public static void startEndingMusic(String pathName) {
        Sound.stopMusic();
        Sound.startMusic(pathName);
    }
}