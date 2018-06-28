package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.sound.Sound;
import javafx.scene.layout.Pane;

public class ScoreUp extends GameEntity implements Interactable {

    private static final int scoreUp =50;

    public ScoreUp(Pane pane) {
        super(pane);

        stillEntityConstructor(Globals.powerupScore);
        timedRemoveEntity(5000);
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.changeScore(scoreUp);
        destroy();
        Sound.playSound("resources/sound/coin_drop.wav");
    }

    @Override
    public String getMessage() {
        return "Got power-up :)";
    }

}
