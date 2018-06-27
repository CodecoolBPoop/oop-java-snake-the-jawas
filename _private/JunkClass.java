public static void setHealthText(Pane pane) {
        Globals.healthText.setText("Health: " + String.valueOf(Globals.snakeHealth));
        Globals.healthText.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        Globals.healthText.setFill(Color.GREEN);
        Globals.healthText.setX(0.8 * Globals.WINDOW_WIDTH);
        Globals.healthText.setY(0.05 * Globals.WINDOW_HEIGHT);
        pane.getChildren().add(Globals.healthText);

        }


public static void setScore(Pane pane) {
        Globals.scoreText.setText("Score: " + String.valueOf(Globals.score));
        Globals.scoreText.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        Globals.scoreText.setFill(Color.ORANGERED);
        Globals.scoreText.setX(0.01 * Globals.WINDOW_WIDTH);
        Globals.scoreText.setY(0.05 * Globals.WINDOW_HEIGHT);
        pane.getChildren().add(Globals.scoreText);

        }

