package com.codecool.snake;

import java.util.concurrent.ThreadLocalRandom;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.enemies.FollowerEnemy;
import com.codecool.snake.entities.enemies.MovingEnemy;
import com.codecool.snake.entities.enemies.TeleporterEnemy;
import com.codecool.snake.entities.powerups.HealthPowerup;
import com.codecool.snake.entities.powerups.ScoreUp;
import com.codecool.snake.entities.powerups.GrowingPowerup;
import com.codecool.snake.entities.powerups.SpeedPowerup;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class SpawnIntaractable {

    int random;

    public void spawnLoop(Pane thisGame) {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(1000),
                ae -> this.spawn(thisGame)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void spawn(Pane game) {
        if (Globals.isGameOver) {
            return;
        }
        random = ThreadLocalRandom.current().nextInt(1, 61);
        if (random <= 10) {
            new MovingEnemy(game);
        } else if (10 < random && random <= 15) {
            new FollowerEnemy(game);
        } else if (15 < random && random <= 20) {
            new TeleporterEnemy(game);
        } else if (20 < random && random <= 22) {
            new TeleporterEnemy(game);
            new TeleporterEnemy(game);
        } else if (22 < random && random <= 30) {
            new ScoreUp(game);
        } else if (30 < random && random <= 35) {
            new HealthPowerup(game);
        } else if (35 < random && random <= 45) {
            new GrowingPowerup(game);
        } else if (45 < random && random <= 50) {
            new SpeedPowerup(game);
        }
    }
}
