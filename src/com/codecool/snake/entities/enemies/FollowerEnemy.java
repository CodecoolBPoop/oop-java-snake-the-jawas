package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import java.util.Random;

// a simple enemy TODO make better ones.
public class FollowerEnemy extends GameEntity implements Animatable, Interactable {

    int speed;
    Random rnd;

    private Point2D heading;
    private static final int damage = 10;

    public FollowerEnemy(Pane pane) {
        super(pane);

        setImage(Globals.followerEnemy);
        pane.getChildren().add(this);
        entitySpicificConstructorSettings();
        timedRemoveEntity(10000);
    }
        //TODO calculate angel

    public void entitySpicificConstructorSettings() {
        speed = 1;
        rnd = new Random();
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
    }

    @Override
    public void step() {
        double snakeXCordinat = 0;
        double snakeYCordinat = 0;
        if (isOutOfBounds()) {
            destroy();
        }
        for (Node node:pane.getChildren()) {
            if(node instanceof SnakeHead){
                snakeXCordinat =((SnakeHead) node).getXCordinat();
                snakeYCordinat = ((SnakeHead) node).getYCordinat();
            }
        }
        if(snakeXCordinat>getX()){
            setX(getX() + speed);
        }else if(snakeXCordinat<getX()){
            setX(getX() - speed);
        }else {}
        if(snakeYCordinat>getY()){
            setY(getY() + speed);
        }else if(snakeYCordinat<getY()){
            setY(getY() - speed);
        }else {}
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
