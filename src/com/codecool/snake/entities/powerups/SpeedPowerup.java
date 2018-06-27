package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class SpeedPowerup extends GameEntity implements Interactable {

    private static final float acceleration = (float) 1.50;

    public SpeedPowerup(Pane pane) {
        super(pane);

        stillEntityConstructor(Globals.powerupSpeed);
        timedRemoveEntity(5000);
    }

    @Override
    public void apply(SnakeHead player) {
        player.speedup(acceleration);
        destroy();
        timedSlowedDown(player, 4000);
    }

    public void timedSlowedDown(SnakeHead player, int after) {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(after),
                ae -> player.slowDown(acceleration)));
        timeline.play();
    }


    @Override
    public String getMessage() {
        String message = "Got 30 extra health points :)" + "\n" + String.valueOf(Globals.snakeHealth1);
        return message;
    }

}
