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

    private static final float speed = 2;
    private static final float turnRate = 2;
    private GameEntity tail; // the last element. Needed to know where to add the next part.
//    private int health;
    private static List players = new ArrayList();
    private int player;

    public SnakeHead(Pane pane, int xc, int yc) {
        super(pane);
        setX(xc);
        setY(yc);
        Globals.snakeHealth = 100;
        tail = this;
        setImage(Globals.snakeHead);
        pane.getChildren().add(this);
        player = players.size()+1;
        players.add(this);
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
                    GameText.updateHealthScoreDiplay();
                }
            }
        }

        // check for game over condition
        if (isOutOfBounds() || Globals.snakeHealth <= 0) {
            System.out.println("Game Over");
            Globals.gameLoop.stop();
        }
    }

    public void addPart(int numParts) {
        for (int i = 0; i < numParts; i++) {
            SnakeBody newPart = new SnakeBody(pane, tail);
            tail = newPart;
        }
    }

    public void changeHealth(int diff) {
        Globals.snakeHealth += diff;
    }

}
