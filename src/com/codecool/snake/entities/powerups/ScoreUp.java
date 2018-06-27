package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScoreUp extends GameEntity implements Interactable {

    private static final int scoreUp =50;

    public ScoreUp(Pane pane) {
        super(pane);

        thisGoesIntoGameEntityConstructor(Globals.powerupScore);
        timedRemoveEntity(5000);
    }

    public void thisGoesIntoGameEntityConstructor(Image gameObjectImage){
        setImage(gameObjectImage);
        pane.getChildren().add(this);

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
