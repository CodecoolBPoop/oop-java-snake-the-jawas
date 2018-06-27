package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.Random;


public class HealthPowerup extends GameEntity implements Interactable {

    private static final int extraHealth = 30;

    public HealthPowerup(Pane pane) {
        super(pane);

        stillEntityConstructor(Globals.powerupHealth);
        timedRemoveEntity(5000);
    }

    // TODO: MOVE THIS TO GAME ENTITY, AND INSERT IMAGE PARAMETER INTO ENTITY SUBCLASS'S CONSTRUCTORS
    public void thisGoesIntoGameEntityConstructor(Image gameObjectImage){
        setImage(gameObjectImage);
        pane.getChildren().add(this);

        Random rnd = new Random();
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
    }

    @Override
    public void apply(SnakeHead player) {
        player.changeHealth(extraHealth);
        destroy();
    }

    @Override
    public String getMessage() {
        String message = "Got 30 extra health points :)" + "\n" + String.valueOf(Globals.snakeHealth1);
        return message;
    }

}
