package org.cis120;

/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * 
 * @version 2.1, Apr 2017
 */

import java.awt.Graphics;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * GameCourt
 *
 * This class holds the primary game logic for how different objects interact
 * with one another. Take time to understand how the timer interacts with the
 * different methods and how it repaints the GUI on every tick().
 */
@SuppressWarnings("serial")
public class SnakeCourt extends JPanel {

    private boolean playing = false; // whether the game is running
    private JLabel displayScore; // current score

    // Game constants
    public static final int COURT_WIDTH = 600;
    public static final int COURT_HEIGHT = 600;

    private Board gameBoard;
    private Direction drxn = Direction.UP;

    private Snake gameSnake;

    private int score = 0;

    // Update interval for timer, in milliseconds
    public static final int INTERVAL = 100;

    public SnakeCourt(JLabel displayScore) {
        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.ORANGE));

        // The timer is an object which triggers an action periodically with the
        // given INTERVAL. We register an ActionListener with this timer, whose
        // actionPerformed() method is called each time the timer triggers. We
        // define a helper method called tick() that actually does everything
        // that should be done in a single timestep.
        Timer timer = new Timer(INTERVAL, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        timer.start(); // MAKE SURE TO START THE TIMER!

        // Enable keyboard focus on the court area. When this component has the
        // keyboard focus, key events are handled by its key listener.
        setFocusable(true);

        // This key listener allows the square to move as long as an arrow key
        // is pressed, by changing the square's velocity accordingly. (The tick
        // method below actually moves the square.)
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT
                        && gameSnake.getDirection() != Direction.RIGHT) {
                    drxn = Direction.LEFT;
                    gameSnake.setDirection(drxn);

                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT
                        && gameSnake.getDirection() != Direction.LEFT) {
                    drxn = Direction.RIGHT;
                    gameSnake.setDirection(drxn);

                } else if (e.getKeyCode() == KeyEvent.VK_DOWN
                        && gameSnake.getDirection() != Direction.UP) {
                    drxn = Direction.DOWN;
                    gameSnake.setDirection(drxn);

                } else if (e.getKeyCode() == KeyEvent.VK_UP
                        && gameSnake.getDirection() != Direction.DOWN) {
                    drxn = Direction.UP;
                    gameSnake.setDirection(drxn);

                }
            }
        });

        this.displayScore = displayScore;
    }

    /**
     * (Re-)set the game to its initial state.
     */
    public void reset() {
        this.drxn = Direction.UP;
        gameSnake = new Snake(new SnakeBody(400, 200, COURT_WIDTH, COURT_HEIGHT));
        this.score = 0;
        gameBoard = new Board(COURT_WIDTH / 20, COURT_HEIGHT / 20);
        gameBoard.updateFood();
        gameBoard.updateSnake(gameSnake);
        //gameBoard.updateReverse();
        gameBoard.updateShrink();

        playing = true;
        displayScore.setText("Score: 0");

        // Make sure that this component has the keyboard focus
        requestFocusInWindow();
    }

    /**
     * This method is called every time the timer defined in the constructor
     * triggers.
     */
    void tick() {
        if (playing) {

            gameSnake.move();

            if (gameSnake.hasHitWall() || gameSnake.hitItself()) {
                playing = false;
            }

            if (gameSnake.hasAteFood(gameBoard.getFood())) {
                gameBoard.generateFood();
                gameBoard.getFood().effect(gameSnake);
                this.score += 10;
                displayScore.setText("Score : " + this.score);

            }

            if (gameSnake.hasAteFood(gameBoard.getShrink()) && gameSnake.length() > 2) {
                gameBoard.generatePoison();
                gameBoard.getShrink().effect(gameSnake);
                
                displayScore.setText("Score : " + this.score);
            }

            if (gameSnake.hasAteFood(gameBoard.getShrink()) && gameSnake.length() <= 2) {
               // playing = false;
            	gameBoard.generatePoison();
                this.score = 0;
                displayScore.setText("Score : " + this.score);
            }

//            if (gameSnake.hasAteFood(gameBoard.getRd())) {
//                gameBoard.generateReverse();
//                gameBoard.getRd().effect(gameSnake);
//            }

            repaint();

            if (!playing) {
                String message = "You Scored : " + " " + this.score + "\n";
                JFrame frame = new JFrame("Game Over");
                frame.setLocation(500, 500);
                JOptionPane.showMessageDialog(
                        frame, message, "Game Over!", JOptionPane.INFORMATION_MESSAGE
                );
            }
            gameBoard.updateFood();
            gameBoard.updateSnake(gameSnake);
           // gameBoard.updateReverse();
            gameBoard.updateShrink();

        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gameSnake.drawSnake(g);
        gameBoard.getFood().draw(g);
        gameBoard.getShrink().draw(g);
       // gameBoard.getRd().draw(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }
}
