package com.codecool.snake;

import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.powerups.HealthPowerup;
import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.entities.text.GameText;
import javafx.animation.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.function.Consumer;

public class Game extends Pane {

    public Game() {
        new SnakeHead(this, 500, 500);

        addUnTimedSimpleEnemy(2);
        addUnTimedSimplePowerup(4);
        addTimedHealthPowerUp(10000);

        new GameText(this);
    }

    // TODO: how to pass the creation of a new object as a return value?????
    public void addTimedHealthPowerUp(int duration) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(duration),
                        ae -> new HealthPowerup(this))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void addUnTimedSimpleEnemy(int numberOfObjects){
        for (int i = 0; i < numberOfObjects; i++) {
            new SimpleEnemy(this);
        }
    }

    public void addUnTimedSimplePowerup(int numberOfObjects){
        for (int i = 0; i < numberOfObjects; i++) {
            new SimplePowerup(this);
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
