package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.sound.Sound;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.Random;


public class MovingEnemy extends GameEntity implements Animatable, Interactable {
    float speed;
    private Point2D heading;
    private static final int damage = 10;
    static int spawnNumber = 0;
    static int buffLimit = 10;
    static float buff = (float) 0.2;

    public MovingEnemy(Pane pane) {
        super(pane);
        entitySpicificConstructorSettings();
    }

    public void entitySpicificConstructorSettings(){
        spawnNumber++;
        if (spawnNumber == buffLimit){
            System.out.println("moving Buffed");
            buffLimit = buffLimit +10;
        }
        speed = 2 + buff;
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
        Sound.playSound("resources/sound/scream_female.wav");
    }

    @Override
    public String getMessage() {
        return "10 damage";
    }

}
