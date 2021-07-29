package org.cis120;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class SnakeTest {

    SnakeBody head = new SnakeBody(300, 200, 600, 600);
    Snake gameSnake = new Snake(head);

    @Test
    public void testGetHead() {
        assertEquals(head, gameSnake.getHead());
    }

    @Test
    public void testCorrectDirection() {
        gameSnake.setDirection(Direction.UP);
        assertEquals(Direction.UP, gameSnake.getDirection());
    }

    @Test
    public void testGetPositions() {
        assertEquals(300, gameSnake.getHead().getPx());
        assertEquals(200, gameSnake.getHead().getPy());
    }

    @Test
    public void testGetLength() {
        assertEquals(2, gameSnake.length());
    }

    @Test
    public void testMove() {
        gameSnake.setDirection(Direction.UP);
        gameSnake.move();
        assertEquals(300, gameSnake.getHead().getPx());
        assertEquals(180, gameSnake.getHead().getPy());
    }

    @Test
    public void testHitWall() {
        gameSnake.setDirection(Direction.UP);

        for (int i = 0; i < 11; i++) {
            gameSnake.move();
        }
        assertTrue(gameSnake.hasHitWall());
    }

    @Test
    public void testEatFood() {
        gameSnake.setDirection(Direction.UP);

        Food fd = new Food(300, 160, 600, 600);
        gameSnake.move();
        gameSnake.move();
        assertTrue(gameSnake.hasAteFood(fd));
    }

    @Test
    public void testGrow() {
        gameSnake.grow();
        assertEquals(3, gameSnake.length());
    }

    @Test
    public void testHitSelf() {
        for (int i = 0; i < 10; i++) {
            gameSnake.grow();
        }

        gameSnake.setDirection(Direction.UP);
        gameSnake.move();
        gameSnake.move();
        gameSnake.setDirection(Direction.RIGHT);
        gameSnake.move();
        gameSnake.setDirection(Direction.DOWN);
        gameSnake.move();
        gameSnake.setDirection(Direction.LEFT);
        gameSnake.move();
        assertTrue(gameSnake.hitItself());
    }

    @Test
    public void testShrink() {
        gameSnake.shrink();
        assertEquals(1, gameSnake.length());
    }

    @Test
    public void testGetTail() {
        assertEquals(220, gameSnake.getTail().getPy());
        assertEquals(300, gameSnake.getTail().getPx());
    }

    @Test
    public void testEcapsulationSnake() {
        SnakeBody newhead = new SnakeBody(300, 180, 600, 600);
        LinkedList<SnakeBody> newHD = gameSnake.getSnake();
        newHD.addFirst(newhead);
        // adding the new head does not change the gameSnake.
        assertFalse(gameSnake.getSnake().contains(newhead));
        assertEquals(300, gameSnake.getHead().getPx());
        assertEquals(200, gameSnake.getHead().getPy());
    }

    @Test
    public void testSetSnake() {
        SnakeBody newhead = new SnakeBody(200, 180, 600, 600);
        Snake newSnake = new Snake(newhead);
        LinkedList<SnakeBody> newS = newSnake.getSnake();
        gameSnake.setSnake(newS);
        assertEquals(200, gameSnake.getHead().getPx());
        assertEquals(180, gameSnake.getHead().getPy());
    }

}
