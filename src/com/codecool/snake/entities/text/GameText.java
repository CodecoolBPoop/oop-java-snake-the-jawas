package com.codecool.snake.entities.text;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class GameText extends GameEntity {

    public GameText(Pane pane) {
        super(pane);
        Globals.healthText.setText("Health: " + String.valueOf(Globals.snakeHealth));
        Globals.healthText.setFont(Font.font ("Verdana", 20));
        Globals.healthText.setFill(Color.RED);
        Globals.healthText.setX(0.8 * Globals.WINDOW_WIDTH);
        Globals.healthText.setY(0.05 * Globals.WINDOW_HEIGHT);
        pane.getChildren().add(Globals.healthText);
    }

    public static void updateHealthScoreDiplay() {
        Globals.healthText.setText("Health: " + String.valueOf(Globals.snakeHealth));
    }

}
