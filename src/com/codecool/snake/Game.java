package com.codecool.snake;

import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.text.GameText;
import com.codecool.snake.sound.Sound;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;

public class Game extends Pane {

    public Game() {
        GameText.setStartText(this, "Snake Game", 0.335, 0.2, Color.BLACK, 50);
        createButton("Single player", Globals.WINDOW_WIDTH * 0.4, Globals.WINDOW_HEIGHT * 0.3, gameMode, this);
        createButton("Two players", Globals.WINDOW_WIDTH * 0.4, Globals.WINDOW_HEIGHT * 0.4, gameMode, this);

        Globals.spawnIntaractable.spawnLoop(this);
    }

    private void makeObjects() {
        new SnakeHead(this, 500, 500, 1);
        new GameText(this, 1);

        if (Globals.multiPlayer) {
            new SnakeHead(this, 400, 500, 2);
            new GameText(this, 2);
        }

    }


    public void start() {
        Scene scene = getScene();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:
                    Globals.leftKeyDown = true;
                    break;
                case RIGHT:
                    Globals.rightKeyDown = true;
                    break;
                case A:
                    Globals.aKeyDown = true;
                    break;
                case D:
                    Globals.dKeyDown = true;
                    break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case LEFT:
                    Globals.leftKeyDown = false;
                    break;
                case RIGHT:
                    Globals.rightKeyDown = false;
                    break;
                case A:
                    Globals.aKeyDown = false;
                    break;
                case D:
                    Globals.dKeyDown = false;
                    break;
            }
            if (event.getCode() == KeyCode.R) {
                Globals.gameLoop.stop();
                Globals.gameObjects.clear();
                Globals.players.clear();
                this.getChildren().clear();
                makeObjects();
                Globals.isGameOver = false;
                Sound.stopMusic();
                start();
            }
        });

        Sound.startMusicWithDelay("resources/sound/off_Limits.wav", 400);
        Globals.gameLoop = new GameLoop();
        Globals.gameLoop.start();

    }

    public void createButton(String name, double x, double y, EventHandler<ActionEvent> event, Pane pane) {
        Button btn = new Button(name);
        btn.setLayoutX(x);
        btn.setLayoutY(y);
        btn.setMinSize(200, 50);
        btn.setStyle("-fx-background-color: \n" +
                "        linear-gradient(#ffd65b, #e68400),\n" +
                "        linear-gradient(#ffef84, #f2ba44),\n" +
                "        linear-gradient(#ffea6a, #efaa22),\n" +
                "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\n" +
                "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,2,3,0;\n" +
                "    -fx-text-fill: #654b00;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 14px;\n" +
                "    -fx-padding: 10 20 10 20;");
        btn.setOnAction(event);
        pane.getChildren().add(btn);

    }

    private EventHandler<ActionEvent> gameMode = e -> {

        if (e.getTarget().toString().contains("Single player")) {
            Globals.multiPlayer = false;
        } else {
            Globals.multiPlayer = true;
        }
        this.getChildren().clear();
        Globals.isGameOver = false;
        makeObjects();

    };

}
