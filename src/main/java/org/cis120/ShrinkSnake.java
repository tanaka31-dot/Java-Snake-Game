package org.cis120;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ShrinkSnake extends PowerUp {

    public static final int SIZE = 20;
    public static final int INIT_VEL_X = 0;
    public static final int INIT_VEL_Y = 0;

    private static final String IMG = "files/snakepoison.png";

    private static BufferedImage img;

    /**
     * Note that, because we don't need to do anything special when constructing
     * a Square, we simply use the superclass constructor called with the
     * correct parameters.
     */
    public ShrinkSnake(int px, int py, int courtWidth, int courtHeight) {
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

    @Override
    public void effect(Snake s) {
        s.shrink();

    }
}
