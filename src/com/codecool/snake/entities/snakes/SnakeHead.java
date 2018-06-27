package com.codecool.snake.entities.snakes;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.enemies.FollowerEnemy;
import com.codecool.snake.entities.enemies.MovingEnemy;
import com.codecool.snake.entities.enemies.TeleporterEnemy;
import com.codecool.snake.entities.text.GameText;
import com.codecool.snake.sound.Sound;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

public class SnakeHead extends GameEntity implements Animatable {

//    private static float speed = 2;
//    private static float turnRate = 2;
    private GameEntity tail; // the last element. Needed to know where to add the next part.
    //    private int health;
    private int snakeID;

    public SnakeHead(Pane pane, int xc, int yc, int id) {
        super(pane);
        setX(xc);
        setY(yc);
        switch (id){
            case 1:
                Globals.snakeHealth1 = 100;
                Globals.score1 = 0;
                Globals.speed1 = 2;
                Globals.turnRate1 = 2;
                break;
            case 2:
                Globals.snakeHealth2 = 100;
                Globals.score2 = 0;
                Globals.speed2 = 2;
                Globals.turnRate2 = 2;
                break;
            default:break;
        }
        tail = this;
        setImage(Globals.snakeHead);
        pane.getChildren().add(this);
        snakeID = id;
        Globals.players.add(this);
        addPart(4);
    }

    public void step() {

        double dir = getRotate();
        if (snakeID == 1) {
            if (Globals.leftKeyDown)
                dir = dir - Globals.turnRate1;

            if (Globals.rightKeyDown)
                dir = dir + Globals.turnRate1;

            Point2D heading = Utils.directionToVector(dir, Globals.speed1);
            setX(getX() + heading.getX());
            setY(getY() + heading.getY());

        }

        if (snakeID == 2) {

            if (Globals.aKeyDown) {
                dir = dir - Globals.turnRate2;
            }

            if (Globals.dKeyDown) {
                dir = dir + Globals.turnRate2;
            }

            Point2D heading = Utils.directionToVector(dir, Globals.speed2);
            setX(getX() + heading.getX());
            setY(getY() + heading.getY());

        }
        // set rotation and position
        setRotate(dir);
//        Point2D heading = Utils.directionToVector(dir, speed);
//        setX(getX() + heading.getX());
//        setY(getY() + heading.getY());

        // check if collided with an enemy or a powerup
        for (GameEntity entity : Globals.getGameObjects()) {
            if (getBoundsInParent().intersects(entity.getBoundsInParent())) {
                if (entity instanceof Interactable) {
                    Interactable interactable = (Interactable) entity;
                    interactable.apply(this);
                    System.out.println(interactable.getMessage());
                }

                if (entity instanceof FollowerEnemy || entity instanceof MovingEnemy || entity instanceof TeleporterEnemy) {
                    Sound.playSound("resources/sound/scream_female.wav");
                }


                if (entity instanceof SnakeHead) {
                    SnakeHead head = (SnakeHead) entity;
                    if (head.snakeID != this.snakeID) {
                        head.removeBody();
                        this.removeBody();

                        head.destroy();
                        this.destroy();
                        System.out.println("Game Over");
                        GameText.displayGameOver(this.snakeID, true);
                        Globals.gameLoop.stop();
                        Globals.isGameOver = true;
                    }
                }


                if (entity instanceof SnakeBody) {
                    SnakeBody head = (SnakeBody) entity;

                    if (head.getHead() != this) {
                        removeBody();
                        this.destroy();
                        System.out.println("Game Over");
                        GameText.displayGameOver(this.snakeID, false);
                        Globals.gameLoop.stop();
                        Globals.isGameOver = true;
                        Sound.stopMusic();
                        Sound.startMusic("resources/sound/PowerBotsLoop.wav");

                    }
                }
            }
        }

        // check for game over condition
        if (isOutOfBounds() || Globals.snakeHealth1 <=0 || Globals.snakeHealth2 <= 0) {
            System.out.println("Game Over");
            GameText.displayGameOver(this.snakeID, false); // Extra Game over line added
            Globals.gameLoop.stop();
            Globals.isGameOver = true;
            Sound.stopMusic();
            Sound.startMusic("resources/sound/PowerBotsLoop.wav");
        }
    }

    public void removeBody() {
        for (GameEntity entity : Globals.getGameObjects()) {
            if (entity instanceof SnakeBody) {
                SnakeBody body = (SnakeBody) entity;
                if (body.getHead() == this) {
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
        if (snakeID == 1) {
            Globals.snakeHealth1 += diff;
        } else if (snakeID == 2) {
            Globals.snakeHealth2 += diff;
        }
    }

    public void speedup(float speed) {
        if (this.getSnakeID() == 1) {
            Globals.speed1 *= speed;
            Globals.turnRate1 *= speed;
        } else if (this.getSnakeID() == 2) {
            Globals.speed2 *= speed;
            Globals.turnRate2 *= speed;
        } else {
            System.out.println("speedup error");
        }
    }

    public void slowDown(float speed) {
        if (this.getSnakeID() == 1) {
            Globals.speed1 /= speed;
            Globals.turnRate1 /= speed;
        } else if (this.getSnakeID() == 2) {
            Globals.speed2 /= speed;
            Globals.turnRate2 /= speed;
        } else {
            System.out.println("slowdown error");
        }
    }


    public int getSnakeID() {
        return snakeID;
    }

    public Double getXCordinat(){
        return getX();
    }

    public Double getYCordinat(){
        return getY();
    }

    public void changeScore(int diff) {
        if (this.getSnakeID() == 1) {
            Globals.score1 += diff;
        } else if (this.getSnakeID() == 2) {
            Globals.score2 += diff;
        } else {
            System.out.println("scoring error");
        }
    }
}
