package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// a simple powerup that makes the snake grow TODO make other powerups
public class HealthPowerup extends GameEntity implements Interactable {

    private static final int extraHealth = 30;
    public static List<HealthPowerup> healthPowerupList = new ArrayList<>();

    public HealthPowerup(Pane pane) {
        super(pane);
        setImage(Globals.powerupHealth);
        pane.getChildren().add(this);
        healthPowerupList.add(this);

        Random rnd = new Random();
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
    }

    public void removeHealthPUObject(int after) {
        Globals.removeGameObject(this);
    }

    @Override
    public void apply(SnakeHead player) {
        player.changeHealth(extraHealth);
        destroy();
    }

    @Override
    public String getMessage() {
        String message = "Got 30 extra health points :)" + "\n" + String.valueOf(Globals.snakeHealth);
        return message;
    }

}
