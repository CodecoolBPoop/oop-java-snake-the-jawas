package com.codecool.snake.entities.text;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class GameText extends GameEntity {

    public GameText(Pane pane) {
        super(pane);
        Globals.healthText.setText("Health: " + String.valueOf(Globals.snakeHealth1));
        Globals.healthText.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        Globals.healthText.setFill(Color.GREEN);
        Globals.healthText.setX(0.8 * Globals.WINDOW_WIDTH);
        Globals.healthText.setY(0.05 * Globals.WINDOW_HEIGHT);
        pane.getChildren().add(Globals.healthText);
    }

    public static void updateHealthScoreDisplay() {
        Globals.healthText.setText("Health: " + String.valueOf(Globals.snakeHealth1));
        updateColorOfText();
    }

    public static void updateColorOfText() {
        if (Globals.snakeHealth1 >= 90) {
            Globals.healthText.setFill(Color.GREEN);
        } else if (90 > Globals.snakeHealth1 && Globals.snakeHealth1 >= 70) {
            Globals.healthText.setFill(Color.LIGHTGREEN);
        } else if (70 > Globals.snakeHealth1 && Globals.snakeHealth1 >= 50) {
            Globals.healthText.setFill(Color.ORANGE);
        } else if (50 > Globals.snakeHealth1 && Globals.snakeHealth1 >= 30) {
            Globals.healthText.setFill(Color.ORANGERED);
        } else if (30 > Globals.snakeHealth1 && Globals.snakeHealth1 >= 10) {
            Globals.healthText.setFill(Color.DARKRED);
        } else if (10 > Globals.snakeHealth1 && Globals.snakeHealth1 >= 0) {
            Globals.healthText.setFill(Color.BLACK);
        }




    }

}
