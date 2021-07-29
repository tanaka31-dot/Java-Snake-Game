package org.cis120;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SnakeBody extends GameObj {
    public static final int SIZE = 20;
    public static final int INIT_VEL_X = 0;
    public static final int INIT_VEL_Y = 0;
    private static final String IMG = "files/snakehead.png";
    private Direction currDrxn;
    private static BufferedImage img;

    /**
     * Note that, because we don't need to do anything special when constructing
     * a Square, we simply use the superclass constructor called with the
     * correct parameters.
     */
    public SnakeBody(int px, int py, int courtWidth, int courtHeight) {
        super(INIT_VEL_X, INIT_VEL_Y, px, py, SIZE, SIZE, courtWidth, courtHeight);
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

    public Direction getCurrDrxn() {
        return this.currDrxn;
    }
}
