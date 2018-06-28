package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Screen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// class for holding all static stuff
public class Globals {
    private static Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    public static final double WINDOW_WIDTH = primaryScreenBounds.getWidth();
    public static final double WINDOW_HEIGHT = primaryScreenBounds.getHeight();

    public static Image snakeHead = new Image("snake_head.png");
    public static Image snakeBody = new Image("snake_body.png");
    public static Image followerEnemy = new Image("follow_enemy.png");
    public static Image teleporterEnemy = new Image("teleporter_enemy.png");
    public static Image powerupBerry = new Image("powerup_berry.png");
    public static Image teleportedEnemy = new Image("teleported_enemy.png");
    public static Image powerupScore = new Image("powerup_score.png");
    public static Image movingEnemy = new Image("moving_enemy.png");
    public static Image powerupHealth = new Image("powerup_health.png");
    public static Image powerupSpeed = new Image("powerup_speed.png");

    public static Text gameOver = new Text();
    public static boolean isGameOver = true;

    public static int snakeHealth1;
    public static int snakeHealth2;
    public static float speed1;
    public static float turnRate1;
    public static float speed2;
    public static float turnRate2;


    public static Text healthText1 = new Text();
    public static Text healthText2 = new Text();

    public static int score1;
    public static int score2;
    public static Text scoreText1 = new Text();
    public static Text scoreText2 = new Text();

    public static boolean multiPlayer;

    public static boolean leftKeyDown;
    public static boolean rightKeyDown;
    public static boolean aKeyDown;
    public static boolean dKeyDown;
    public static List<SnakeHead> players = new ArrayList();
    public static List<GameEntity> gameObjects;
    public static List<GameEntity> newGameObjects; // Holds game objects crated in this frame.
    public static List<GameEntity> oldGameObjects; // Holds game objects that will be destroyed this frame.
    public static SpawnIntaractable spawnIntaractable = new SpawnIntaractable();
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
        oldGameObjects.add(toRemove);
    }

    public static void removeAllGameObjects() {
        gameObjects.clear();
        newGameObjects.clear();
        oldGameObjects.clear();
    }

    public static List<GameEntity> getGameObjects() {
        return Collections.unmodifiableList(gameObjects);
    }
}
