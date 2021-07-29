package org.cis120;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RunSnake implements Runnable {

    @Override
    public void run() {

        final JFrame frame = new JFrame("SNAKE GAME");
        frame.setLocation(600, 600);
        frame.setBackground(Color.MAGENTA);

        String instructions = "So nice of you to stop by!! \n "
                + "Instructions for the game:\n"
                + "1. Use the arrow keys to move snake in desired direction.\n"
                + "2. Do not let your head go beyond the wall or you will die \n"
                + "3. Make sure you do not run into yourself or you will also die.\n"
                + "4. Eat the food(the green one) to grow and get points.\n"
                + "5. Beware of the puple poison it will cause you to shrink up and "
                + "loose points or die\n"
                + "   if you have length 2.\n"
                + "6. You can eat the purple arrow if you want to reverse your direction.\n"
                + "5. You can also press the start button to start a new game or \n"
                + "   to start all over again in the middle of the game but in the second \n"
                + "   case all your progress in "
                + "the current game is lost.\n"
                + "\n"
                + "Press okay to start. Let's GO!!";

        JOptionPane.showMessageDialog(
                frame, instructions, "SNAKE GAME!", JOptionPane.INFORMATION_MESSAGE
        );
        

        final JPanel status_panel = new JPanel(new BorderLayout(5, 0));
        status_panel.setBackground(Color.LIGHT_GRAY);
        frame.add(status_panel, BorderLayout.SOUTH);
        final JLabel displayScore = new JLabel("Score:  0");
        displayScore.setFont(new Font("Serif", Font.PLAIN, 40));

        status_panel.add(displayScore);
        final SnakeCourt court = new SnakeCourt(displayScore);
        court.setBackground(Color.BLACK);
        frame.add(court, BorderLayout.CENTER);

        final JPanel control_panel = new JPanel();
        control_panel.setBackground(Color.LIGHT_GRAY);
        frame.add(control_panel, BorderLayout.NORTH);

        final JButton reset = new JButton("Start");
        reset.setBackground(Color.GREEN);
        reset.setFont(new Font("Serif", Font.PLAIN, 20));
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.reset();
            }
        });
        control_panel.add(reset);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start game
        court.reset();
    }

}
