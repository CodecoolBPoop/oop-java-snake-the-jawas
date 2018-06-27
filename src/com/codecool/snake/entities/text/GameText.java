package com.codecool.snake.entities.text;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class GameText extends GameEntity {

    public GameText(Pane pane) {
        super(pane);
        setText(pane, "Health: ", Globals.snakeHealth, Globals.healthText, 0.8, 0.05, Color.GREEN, 20);
        setText(pane, "Score: ", Globals.score, Globals.scoreText, 0.01, 0.05, Color.ORANGERED, 20);

        Globals.gameOver.setText("");
        pane.getChildren().add(Globals.gameOver);
    }

    public static void setText(Pane pane, String title, int scoreValue, Text textToSet, double xCoordinate, double yCoordinate, Color textColor, int fontSize) {
        textToSet.setText(title + String.valueOf(scoreValue));
        textToSet.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, fontSize));
        textToSet.setFill(textColor);
        textToSet.setX(xCoordinate * Globals.WINDOW_WIDTH);
        textToSet.setY(yCoordinate * Globals.WINDOW_HEIGHT);
        pane.getChildren().add(textToSet);
    }

    public static void updateHealthScoreDiplay() {
        Globals.healthText.setText("Health: " + String.valueOf(Globals.snakeHealth));
        updateColorOfText();
    }

    public static void updateScoreDisplay() {
        Globals.scoreText.setText("Score: " + String.valueOf(Globals.score));
    }


    public static void updateColorOfText() {
        if (Globals.snakeHealth >= 90) {
            Globals.healthText.setFill(Color.GREEN);
        } else if (90 > Globals.snakeHealth && Globals.snakeHealth >= 70) {
            Globals.healthText.setFill(Color.LIGHTGREEN);
        } else if (70 > Globals.snakeHealth && Globals.snakeHealth >= 50) {
            Globals.healthText.setFill(Color.ORANGE);
        } else if (50 > Globals.snakeHealth && Globals.snakeHealth >= 30) {
            Globals.healthText.setFill(Color.ORANGERED);
        } else if (30 > Globals.snakeHealth && Globals.snakeHealth >= 10) {
            Globals.healthText.setFill(Color.DARKRED);
        } else if (10 > Globals.snakeHealth && Globals.snakeHealth >= 0) {
            Globals.healthText.setFill(Color.BLACK);
        }
    }

    public static void displayGameOver(int score) {
        String gameOverMessage = String.format("Game over\nYour score is %d points", score); // score should come here
        Globals.gameOver.setText(gameOverMessage);
        Globals.gameOver.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 30));
        Globals.gameOver.setFill(Color.INDIANRED);
        Globals.gameOver.setX(0.2 * Globals.WINDOW_WIDTH);
        Globals.gameOver.setY(0.5 * Globals.WINDOW_HEIGHT);
    }

    public String getMessage() {
        String message = "Got 30 extra health points :)" + "\n" + String.valueOf(Globals.snakeHealth);
        return message;
    }



}
