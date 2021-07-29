package org.cis120;

import java.awt.Graphics;

public abstract class PowerUp extends GameObj {

    public static final int SIZE = 20;
    public static final int INIT_VEL_X = 0;
    public static final int INIT_VEL_Y = 0;
    public static final int BOARD_WIDTH = 600;
    public static final int BOARD_HEIGHT = 600;
    private int px;
    private int py;

    public PowerUp(int px, int py, int courtWidth, int courtHeight) {
        super(INIT_VEL_X, INIT_VEL_Y, px, py, SIZE, SIZE, courtWidth, courtHeight);
        this.px = px;
        this.py = py;
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(this.px, this.py, BOARD_WIDTH, BOARD_HEIGHT);

    }

    public abstract void effect(Snake s);
}
