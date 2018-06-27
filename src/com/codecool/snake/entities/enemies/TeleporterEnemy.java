package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.Random;
// a simple enemy TODO make better ones.
public class TeleporterEnemy extends GameEntity implements Animatable, Interactable{

    boolean teleported = false;
    private static final int damage = 30;

    public TeleporterEnemy(Pane pane) {
        super(pane);
        stillEntityConstructor(Globals.teleporterEnemy);
    }

    @Override
    public void step() {
        if (!teleported){
            teleported = true;
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(5000),
                    ae -> teleport()));
            timeline.play();
        }
    }

    public void teleport(){
        Random rnd = new Random();
        setX(rnd.nextDouble()* Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble()* Globals.WINDOW_HEIGHT);
        setImage(Globals.teleportedEnemy);
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(5000),
                ae -> destroy()));
        timeline.play();
    }
    @Override
    public void apply(SnakeHead player) {
        player.changeHealth(-damage);
        destroy();
    }

    @Override
    public String getMessage() {
        return "10 damage";
    }
}