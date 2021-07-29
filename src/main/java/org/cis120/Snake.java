package org.cis120;

import java.util.LinkedList;
import java.awt.Graphics;

public class Snake {

    private LinkedList<SnakeBody> snakeParts = new LinkedList<>();
    private Direction drxn = Direction.UP;

    public Snake(SnakeBody initPos) {

        SnakeBody tail = new SnakeBody(initPos.getPx(), initPos.getPy() + 20, 600, 600);

        snakeParts.add(initPos);
        snakeParts.addLast(tail);

    }

    public void grow() {
        SnakeBody currTail = snakeParts.getLast();
        SnakeBody newTail = new SnakeBody(currTail.getPx(), currTail.getPy(), 600, 600);
        snakeParts.addLast(newTail);
    }

    public void shrink() {
        snakeParts.removeLast();

    }

    public int length() {
        return snakeParts.size();
    }

    public boolean hasAteFood(GameObj next) {
        SnakeBody head = snakeParts.getFirst();
        if (head.hitObj(next) != null || head.intersects(next)) {
            return true;
        }
        return false;
    }

    public SnakeBody getHead() {
        SnakeBody head = snakeParts.getFirst();
        return head;
    }

    public boolean hasHitWall() {
        SnakeBody head = snakeParts.getFirst();
        if (head.hitWall() != null) {
            return true;
        }
        return false;
    }

    public boolean hitItself() {
        SnakeBody head = snakeParts.getFirst();
        for (SnakeBody s : snakeParts) {
            if (s != head && head.willIntersect(s)) {
                return true;
            }
        }
        return false;
    }

    public Direction getDirection() {
        return this.drxn;
    }

    public Direction setDirection(Direction dir) {
        this.drxn = dir;
        return this.drxn;
    }

    public LinkedList<SnakeBody> getSnake() {
        LinkedList<SnakeBody> toReturn = new LinkedList<>();
        for (SnakeBody s : snakeParts) {
            toReturn.add(s);
        }
        return toReturn;
    }

    public void move() {
        SnakeBody head = snakeParts.getFirst();

        SnakeBody newHead = null;

        if (drxn == Direction.DOWN) {

            newHead = new SnakeBody(head.getPx(), head.getPy() + 20, 600, 600);

        }

        if (drxn == Direction.UP) {
            newHead = new SnakeBody(head.getPx(), head.getPy() - 20, 600, 600);

        }

        if (drxn == Direction.LEFT) {
            newHead = new SnakeBody(head.getPx() - 20, head.getPy(), 600, 600);

        }
        if (drxn == Direction.RIGHT) {
            newHead = new SnakeBody(head.getPx() + 20, head.getPy(), 600, 600);

        }
        snakeParts.addFirst(newHead);
        snakeParts.removeLast();

    }

    public void drawSnake(Graphics g) {
        for (SnakeBody s : snakeParts) {
            s.draw(g);
        }
    }

    @Override
    public boolean equals(Object obj) {
        for (SnakeBody s : snakeParts) {
            if ((getHead().getPx() == (s.getPx())) && getHead().getPy() == s.getPy()) {
                return true;
            }
        }
        return false;
    }

    public void setSnake(LinkedList<SnakeBody> sb) {
        this.snakeParts = sb;

    }

    public SnakeBody getTail() {
        return snakeParts.getLast();
    }

}
