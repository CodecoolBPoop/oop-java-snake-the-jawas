package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// class for holding all static stuff
public class Globals {

    public static final double WINDOW_WIDTH = 1000;
    public static final double WINDOW_HEIGHT = 700;

    public static Image snakeHead = new Image("snake_head.png");
    public static Image snakeBody = new Image("snake_body.png");
    public static Image followerEnemy = new Image("first_enemy.png");
    public static Image teleporterEnemy = new Image("second_enemy.png");
    public static Image powerupBerry = new Image("powerup_berry.png");
    public static Image teleportedEnemy = new Image("teleported_enemy.png");

    //.. put here the other images you want to use
    public static Image powerupHealth = new Image("powerup_health.png");


    public static Text healthText = new Text();

    public static int snakeHealth;

    public static boolean leftKeyDown;
    public static boolean rightKeyDown;
    public static List<GameEntity> gameObjects;
    public static List<GameEntity> newGameObjects; // Holds game objects crated in this frame.
    public static List<GameEntity> oldGameObjects; // Holds game objects that will be destroyed this frame.
    public static GameLoop gameLoop;

    static {
        gameObjects = new LinkedList<>();
        newGameObjects = new LinkedList<>();
        oldGameObjects = new LinkedList<>();
    }

    public static void addGameObject(GameEntity toAdd) {
        newGameObjects.add(toAdd);
    }

    public static void removeGameObject(GameEntity toRemove) {
        newGameObjects.remove(toRemove); // ati: added this line. seems logical...
        oldGameObjects.add(toRemove);
    }

    public static List<GameEntity> getGameObjects() {
        return Collections.unmodifiableList(gameObjects);
    }
}
