package com.codecool.snake.entities.text;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class GameText extends GameEntity {

    //TODO: CLEAN CODE THIS
    public GameText(Pane pane) {
        super(pane);
        setHealthText(pane);
        setScore(pane);

        Globals.gameOver.setText("");
        pane.getChildren().add(Globals.gameOver);
    }

    public static void displayGameOver(int score) {
        String gameOverMessage = String.format("Game over\nYour score is %d points", score); // score should come here
        Globals.gameOver.setText(gameOverMessage);
        Globals.gameOver.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 30));
        Globals.gameOver.setFill(Color.INDIANRED);
        Globals.gameOver.setX(0.2 * Globals.WINDOW_WIDTH);
        Globals.gameOver.setY(0.5 * Globals.WINDOW_HEIGHT);
    }

    public static void setHealthText(Pane pane) {
        Globals.healthText.setText("Health: " + String.valueOf(Globals.snakeHealth));
        Globals.healthText.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        Globals.healthText.setFill(Color.GREEN);
        Globals.healthText.setX(0.8 * Globals.WINDOW_WIDTH);
        Globals.healthText.setY(0.05 * Globals.WINDOW_HEIGHT);
        pane.getChildren().add(Globals.healthText);

    }

    public static void updateHealthScoreDiplay() {
        Globals.healthText.setText("Health: " + String.valueOf(Globals.snakeHealth));
        updateColorOfText();
    }

    public static void setScore(Pane pane) {
        Globals.scoreText.setText("Score: " + String.valueOf(Globals.score));
        Globals.scoreText.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        Globals.scoreText.setFill(Color.ORANGERED);
        Globals.scoreText.setX(0.01 * Globals.WINDOW_WIDTH);
        Globals.scoreText.setY(0.05 * Globals.WINDOW_HEIGHT);
        pane.getChildren().add(Globals.scoreText);

    }

    public static void updateScore() {
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

    public String getMessage() {
        String message = "Got 30 extra health points :)" + "\n" + String.valueOf(Globals.snakeHealth);
        return message;
    }



}
