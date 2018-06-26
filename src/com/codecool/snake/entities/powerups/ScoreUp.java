package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScoreUp extends GameEntity implements Interactable {

    private static final int scoreUp =50;
    public static List<ScoreUp> scorePowerupList = new ArrayList<>();

    public ScoreUp(Pane pane) {
        super(pane);
        setImage(Globals.powerupScore);
        pane.getChildren().add(this);
        scorePowerupList.add(this);

        Random rnd = new Random();
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.changeScore(scoreUp);
        destroy();
    }

    @Override
    public String getMessage() {
        return "Got power-up :)";
    }
}
