package com.codecool.snake.entities;
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

    public void spawnLoop(Pane thisGame){
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(1000),
                ae -> this.spawn(thisGame)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void spawn(Pane game){
        if (Globals.isGameOver) {
            return;
        }
        random = ThreadLocalRandom.current().nextInt(1,8);
        switch (random){
            case 1: new FollowerEnemy(game);break;
            case 2: new TeleporterEnemy(game);break;
            case 3: new HealthPowerup(game);break;
            case 4: new ScoreUp(game);break;
            case 5: new GrowingPowerup(game);break;
            case 6: new MovingEnemy(game);break;
            case 7: new SpeedPowerup(game);break;
            case 8: default:break;
        }
    }
}
