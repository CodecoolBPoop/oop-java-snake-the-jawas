package com.codecool.snake.entities.snakes;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.text.GameText;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class SnakeHead extends GameEntity implements Animatable {

    private static final float speed = 4;
    private static final float turnRate = 2;
    private GameEntity tail; // the last element. Needed to know where to add the next part.
//    private int health;
    private int player;

    public SnakeHead(Pane pane, int xc, int yc) {
        super(pane);
        setX(xc);
        setY(yc);
        Globals.snakeHealth = 100;
        Globals.score = 0;
        tail = this;
        setImage(Globals.snakeHead);
        pane.getChildren().add(this);
        player = Globals.players.size()+1;
        Globals.players.add(this);
        addPart(4);
    }

    public void step() {

        double dir = getRotate();
        if(player==1){
            if (Globals.leftKeyDown)
                dir = dir - turnRate;

            if (Globals.rightKeyDown)
                dir = dir + turnRate;
        }

        if(player==2){

            if (Globals.aKeyDown)
                dir = dir - turnRate;

            if (Globals.dKeyDown)
                dir = dir + turnRate;

        }
        // set rotation and position
        setRotate(dir);
        Point2D heading = Utils.directionToVector(dir, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());

        // check if collided with an enemy or a powerup
        for (GameEntity entity : Globals.getGameObjects()) {
            if (getBoundsInParent().intersects(entity.getBoundsInParent())) {
                if (entity instanceof Interactable) {
                    Interactable interactable = (Interactable) entity;
                    interactable.apply(this);
                    System.out.println(interactable.getMessage());
                }


                if(entity instanceof SnakeHead) {
                    SnakeHead head = (SnakeHead) entity;
                   if(head.player != this.player){
                        head.removeBody();
                        this.removeBody();

                        head.destroy();
                        this.destroy();
                        System.out.println("Game Over");
                        Globals.gameLoop.stop();
                    }
                }


                if(entity instanceof SnakeBody) {
                    SnakeBody head = (SnakeBody) entity;

                    if(head.getHead() != this) {
                        removeBody();
                        this.destroy();
                    }
                }
            }
        }

        // check for game over condition
        if (isOutOfBounds() || Globals.snakeHealth <= 0) {
            System.out.println("Game Over");
            GameText.displayGameOver(Globals.score); // Extra Game over line added
            Globals.gameLoop.stop();

        }
    }

    public void removeBody() {
        for (GameEntity entity : Globals.getGameObjects()) {
            if(entity instanceof SnakeBody) {
                SnakeBody body = (SnakeBody) entity;
                if(body.getHead() == this){
                    body.destroy();
                }
            }
        }
    }

    public void addPart(int numParts) {
        for (int i = 0; i < numParts; i++) {
            SnakeBody newPart = new SnakeBody(pane, tail, this);
            tail = newPart;
        }
    }

    public void changeHealth(int diff) {
        Globals.snakeHealth += diff;
    }

    public Double getXCordinat(){
        return getX();
    }

    public Double getYCordinat(){
        return getY();
    }

    public void changeScore(int diff) {
        Globals.score += diff;
    }
}
