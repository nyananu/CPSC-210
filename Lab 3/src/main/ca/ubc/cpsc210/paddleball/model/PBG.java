package ca.ubc.cpsc210.paddleball.model;

import java.awt.event.KeyEvent;
import java.util.Random;

/*
 * Represents a paddle ball game.
 */
public class PBG {
    public static final int DIMENSION1 = 800;
    public static final int DIMENSION2 = 600;
    private static final Random RND = new Random();

    private Ball ballObject;
    private Paddle paddleObject;
    private boolean stop;

    // Constructs a Paddle Ball Game
    // EFFECTS:  creates ball at random location at top of screen
    public PBG() {
        setUp();
    }

    public Paddle getPaddle() {
        return paddleObject;
    }

    public Ball getBall() {
        return ballObject;
    }

    // Is game over?
    // EFFECTS: returns true if game is over, false otherwise
    public boolean isOver() {
        return stop;
    }

    // Updates the game on clock tick
    // MODIFIES: this
    // EFFECTS:  updates ball, paddle and game over status
    public void update() {
        ballObject.move();
        paddleObject.move();

        checkHitSomething();
        checkstyle();
    }

    // Responds to key press codes
    // MODIFIES: this
    // EFFECTS:  turns paddle and resets game (if game over) in response to
    //           given key pressed code
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_R && stop) {
            setUp();
        } else if (key == KeyEvent.VK_X) {
            System.exit(0);
        } else {
            paddleControl(key);
        }
    }


    // Sets / resets the game
    // MODIFIES: this
    // EFFECTS:  clears list of missiles and invaders, initializes tank
    private void setUp() {
        ballObject = new Ball(RND.nextInt(PBG.DIMENSION1), Ball.SIZE / 2);
        paddleObject = new Paddle(DIMENSION1 / 2);
        stop = false;
    }

    // Controls the paddle
    // MODIFIES: this
    // EFFECTS: changes direction of paddle in response to key code
    private void paddleControl(int padKey) {
        if (padKey == KeyEvent.VK_KP_LEFT || padKey == KeyEvent.VK_LEFT) {
            paddleObject.left();
        } else if (padKey == KeyEvent.VK_KP_RIGHT || padKey == KeyEvent.VK_RIGHT) {
            paddleObject.right();
        }
    }

    // Checks for collision between ball and paddle
    // MODIFIES: this
    // EFFECTS:  bounces ball if it collides with paddle
    private void checkHitSomething() {
        if (ballObject.doSomething(paddleObject)) {
            ballObject.bounceOffPaddle();
        }
    }

    // Is game over? (Has ball hit ground?)
    // MODIFIES: this
    // EFFECTS:  if ball has hit ground, game is marked as over
    private void checkstyle() {
        if (ballObject.getY0() > DIMENSION2) {
            stop = true;
        }
    }
}
