package com.codecool.snake;

import com.codecool.snake.entities.SpawnIntaractable;
import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.entities.text.GameText;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class Game extends Pane {

    public Game() {
        makeObjects();
//        SpawnIntaractable spawnIntaractable = new SpawnIntaractable();
        Globals.spawnIntaractable.spawnLoop(this);
    }
    private void makeObjects(){
        new SnakeHead(this, 500, 500);
        new SnakeHead(this, 400, 500);
        new GameText(this);
    }


    public void start() {
        Scene scene = getScene();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = true; break;
                case RIGHT: Globals.rightKeyDown  = true; break;
                case A:  Globals.aKeyDown  = true; break;
                case D: Globals.dKeyDown  = true; break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = false; break;
                case RIGHT: Globals.rightKeyDown  = false; break;
                case A:  Globals.aKeyDown  = false; break;
                case D: Globals.dKeyDown  = false; break;
            }
            if (event.getCode() == KeyCode.R) {
                Globals.gameLoop.stop();
                Globals.gameObjects.clear();
                Globals.players.clear();
                this.getChildren().clear();
                makeObjects();
                Globals.isGameOver = false;
                start();
            }
        });


        Globals.gameLoop = new GameLoop();
        Globals.gameLoop.start();

    }
}
