package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.Random;


public class MovingEnemy extends GameEntity implements Animatable, Interactable {
    int speed;

    private Point2D heading;
    private static final int damage = 10;

    public MovingEnemy(Pane pane) {
        super(pane);
        entitySpicificConstructorSettings();
    }

    public void entitySpicificConstructorSettings(){
        speed = 2;
        setImage(Globals.movingEnemy);
        canSpawn();
        pane.getChildren().add(this);
        Random rnd = new Random();
        double direction = rnd.nextDouble() * 360;
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);
        canSpawn();
    }

    @Override
    public void step() {
        if (isOutOfBounds()) {
            destroy();
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
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
