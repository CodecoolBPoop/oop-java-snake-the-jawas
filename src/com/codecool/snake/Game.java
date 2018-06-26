package com.codecool.snake;

import com.codecool.snake.entities.enemies.HealthDamage;
import com.codecool.snake.entities.powerups.HealthPowerup;
import com.codecool.snake.entities.powerups.ScoreUp;
import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.entities.text.GameText;
import javafx.animation.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Game extends Pane {

    public Game() {
        new SnakeHead(this, 500, 500);

        addUnTimedHealthDamage(10);
        addTimedHealthDamage(1000);
        addTimedScorePowerUp(3000);
        addTimedHealthPowerUp(25000);

        addTimedSimplePowerUp(25000);

        new GameText(this);
    }

    // TODO: how to pass the creation of a new object as a return value?????
    public void addTimedScorePowerUp(int duration) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(duration),
                        ae -> new ScoreUp(this))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

//    public void timedRemove() {
//        Timeline timeline = new Timeline(new KeyFrame(
//                Duration.millis(2500),
//                ae -> "HOW TO GET THE ELEMENT THAT HAS JUST BEEN CREATED???"));
//        timeline.play();    }

    public void addTimedHealthPowerUp(int duration) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(duration),
                        ae -> new HealthPowerup(this))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void addTimedHealthDamage(int duration) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(duration),
                        ae -> new HealthDamage(this))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void addTimedSimplePowerUp(int duration) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(duration),
                        ae -> new SimplePowerup(this))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void addUnTimedHealthDamage(int numberOfObjects){
        for (int i = 0; i < numberOfObjects; i++) {
            new HealthDamage(this);
        }
    }

    public void start() {
        Scene scene = getScene();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = true; break;
                case RIGHT: Globals.rightKeyDown  = true; break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = false; break;
                case RIGHT: Globals.rightKeyDown  = false; break;
            }
        });
        Globals.gameLoop = new GameLoop();
        Globals.gameLoop.start();
    }
}
