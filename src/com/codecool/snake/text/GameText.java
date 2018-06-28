package com.codecool.snake.text;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class GameText extends GameEntity {

    public GameText(Pane pane, int id) {
        super(pane);
        switch (id) {
            case 1:
                setText(pane, "Player1 Health: ", Globals.snakeHealth1, Globals.healthText1, 0.8, 0.05, Color.GREEN, 20);
                setText(pane, "Player1 Score: ", Globals.score1, Globals.scoreText1, 0.8, 0.08, Color.ORANGERED, 20);
                Globals.gameOver.setText("");
                pane.getChildren().add(Globals.gameOver);
                break;
            case 2:
                setText(pane, "Player2 Health: ", Globals.snakeHealth2, Globals.healthText2, 0.01, 0.05, Color.GREEN, 20);
                setText(pane, "Player2 Score: ", Globals.score2, Globals.scoreText2, 0.01, 0.08, Color.ORANGERED, 20);
                break;
            default:break;
        }

    }

    public static void setText(Pane pane, String title, int scoreValue, Text textToSet, double xCoordinate, double yCoordinate, Color textColor, int fontSize) {
        textToSet.setText(title + String.valueOf(scoreValue));
        textToSet.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, fontSize));
        textToSet.setFill(textColor);
        textToSet.setX(xCoordinate * Globals.WINDOW_WIDTH);
        textToSet.setY(yCoordinate * Globals.WINDOW_HEIGHT);
        pane.getChildren().add(textToSet);
    }

    public static void updateHealthScoreDisplay(Text healthText, String healthString, int score) {
        healthText.setText(healthString + String.valueOf(score));
        updateColorOfText();
    }

    public static void updateScoreDisplay(Text scoreText, String scoreString, int score) {
        scoreText.setText(scoreString + String.valueOf(score));
    }


    public static void updateColorOfText() {
        if (Globals.snakeHealth1 >= 90) {
            Globals.healthText1.setFill(Color.GREEN);
        } else if (90 > Globals.snakeHealth1 && Globals.snakeHealth1 >= 70) {
            Globals.healthText1.setFill(Color.LIGHTGREEN);
        } else if (70 > Globals.snakeHealth1 && Globals.snakeHealth1 >= 50) {
            Globals.healthText1.setFill(Color.ORANGE);
        } else if (50 > Globals.snakeHealth1 && Globals.snakeHealth1 >= 30) {
            Globals.healthText1.setFill(Color.ORANGERED);
        } else if (30 > Globals.snakeHealth1 && Globals.snakeHealth1 >= 10) {
            Globals.healthText1.setFill(Color.DARKRED);
        } else if (10 > Globals.snakeHealth1 && Globals.snakeHealth1 >= 0) {
            Globals.healthText1.setFill(Color.BLACK);
        }
    }

    public static void displayGameOver(int snakeID, boolean draw) {
        int score;
        String winner;
        String fullMessage;
        if (snakeID == 1) {
            score = Globals.score2;
            winner = "Player 2";
            fullMessage = String.format("Game over\n%s won\nWinner\'s score is %d points", winner, score);
        } else if (snakeID == 2) {
            score = Globals.score1;
            winner = "Player 1";
            fullMessage = String.format("Game over\n%s won\nWinner\'s score is %d points", winner, score);
        } else {
            score = 100000000;
            winner = "1000000000";
            fullMessage = "Fuck this shit!";
        }
        if (draw) {
            if (Globals.score1 > Globals.score2) {
                winner = "Player 1";
                score = Globals.score1;
                fullMessage = String.format("Game over\n%s won with higher score\nWinner\'s score is %d points", winner, score);
            } else if (Globals.score1 < Globals.score2) {
                winner = "Player 2";
                score = Globals.score2;
                fullMessage = String.format("Game over\n%s won with higher score\nWinner\'s score is %d points", winner, score);
            } else {
                fullMessage = String.format("Game over\nIt's a draw\nBoth players\'s score is %d points", score);
            }
        }
        String gameOverMessage = String.format(fullMessage);
        Globals.gameOver.setText(gameOverMessage);
        Globals.gameOver.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 30));
        Globals.gameOver.setFill(Color.INDIANRED);
        Globals.gameOver.setX(0.2 * Globals.WINDOW_WIDTH);
        Globals.gameOver.setY(0.5 * Globals.WINDOW_HEIGHT);
    }

    public String getMessage() {
        String message = "Got 30 extra health points :)" + "\n" + String.valueOf(Globals.snakeHealth1);
        return message;
    }
}

