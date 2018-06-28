package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.sound.Sound;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.Random;

// a simple powerup that makes the snake grow TODO make other powerups
public class SimplePowerup extends GameEntity implements Interactable {

    public SimplePowerup(Pane pane) {
        super(pane);
        stillEntityConstructor(Globals.powerupBerry);
        timedRemoveEntity(10000);
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.addPart(4);
        destroy();
        Sound.playSound("resources/sound/eating_munch.wav");
    }

    @Override
    public String getMessage() {
        return "Got power-up :)";
    }

}
