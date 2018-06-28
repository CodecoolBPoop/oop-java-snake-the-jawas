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

public class Game extends Pane {

    public Game() {
        createButton("Player1",100,100, gameMode, this);
        createButton("Player2",150,100, gameMode, this);
        Globals.spawnIntaractable.spawnLoop(this);
    }
    private void makeObjects(){
        new SnakeHead(this, 500, 500, 1);
        new GameText(this, 1);

        if(Globals.multiPlayer) {
            new SnakeHead(this, 400, 500, 2);
            new GameText(this, 2);
        }

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
                Sound.stopMusic();
                start();
            }
        });

        Sound.startMusicWithDelay("resources/sound/off_Limits.wav", 400);
        Globals.gameLoop = new GameLoop();
        Globals.gameLoop.start();

    }

    public void createButton(String name, int x, int y, EventHandler<ActionEvent> event, Pane pane) {
        Button btn = new Button(name) ;
        btn.setLayoutX(x);
        btn.setLayoutY(y);
        btn.setOnAction(event);
        pane.getChildren().add(btn);

    }

    private EventHandler<ActionEvent> gameMode = e -> {
       if(e.getTarget().toString().contains("Player1")){
           Globals.multiPlayer = false;
       } else {
           Globals.multiPlayer = true;
       }

       this.getChildren().clear();


       Globals.isGameOver = false;
        makeObjects();

    };

}
