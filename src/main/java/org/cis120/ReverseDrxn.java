package org.cis120;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;

import javax.imageio.ImageIO;

public class ReverseDrxn extends PowerUp {

    public static final int SIZE = 20;
    public static final int INIT_VEL_X = 0;
    public static final int INIT_VEL_Y = 0;

    private static final String IMG = "files/arrow.png";

    private static BufferedImage img;

    /**
     * Note that, because we don't need to do anything special when constructing
     * a Square, we simply use the superclass constructor called with the
     * correct parameters.
     */
    public ReverseDrxn(int px, int py, int courtWidth, int courtHeight) {
        super(px, py, courtWidth, courtHeight);
        try {
            img = ImageIO.read(new File(IMG));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, this.getPx(), this.getPy(), this.getWidth(), this.getHeight(), null);
    }

    public void reverse(Snake s) {

        Collections.reverse(s.getSnake());

        if (s.getDirection() == Direction.UP) {
            s.setDirection(Direction.DOWN);
            s.move();
        } else if (s.getDirection() == Direction.DOWN) {
            s.setDirection(Direction.UP);
            s.move();
        } else if (s.getDirection() == Direction.LEFT) {
            s.setDirection(Direction.RIGHT);
            s.move();
        } else if (s.getDirection() == Direction.RIGHT) {
            s.setDirection(Direction.LEFT);
            s.move();
        }

    }

    @Override
    public void effect(Snake s) {
        reverse(s);

    }

}
