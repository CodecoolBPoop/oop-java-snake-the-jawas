package com.codecool.snake.entities;

import com.codecool.snake.Game;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.entities.powerups.SpeedPowerup;
import com.codecool.snake.sound.Sound;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.Random;

// The base class for every game entity.
public abstract class GameEntity extends ImageView {

    protected Pane pane;

    protected GameEntity(Pane pane) {
        this.pane = pane;
        // add to the main loop.
        Globals.addGameObject(this);
    }

    public void stillEntityConstructor(Image gameObjectImage){
        setImage(gameObjectImage);
        pane.getChildren().add(this);
        canSpawn();
    }

    public void destroy() {
        if (!Globals.isGameOver) {
            if (getParent() != null) {
                pane.getChildren().remove(this);
            }
            Globals.removeGameObject(this);
        }
    }

    protected boolean isOutOfBounds() {
        if (getX() > Globals.WINDOW_WIDTH || getX() < 0 ||
            getY() > Globals.WINDOW_HEIGHT || getY() < 0) {
            return true;
        }
        return false;
    }

    public void timedRemoveEntity(int after) {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(after),
                ae -> destroy()));
        timeline.play();
    }
    public void canSpawn() {
        Random rnd = new Random();
        while (true) {
            double x = rnd.nextDouble() * Globals.WINDOW_WIDTH;
            double y = rnd.nextDouble() * Globals.WINDOW_HEIGHT;
            boolean canSpawn = true;
            for (SnakeHead head : Globals.players) {
                if (head.getX() + 50 < x || head.getX() - 50 > x) {

                } else if (head.getY() + 50 < y || head.getY() - 50 > y) {
                }else {
                    canSpawn = false;
                }
            }
            if (canSpawn) {
                setX(x);
                setY(y);
                break;
            }
        }
    }

}
