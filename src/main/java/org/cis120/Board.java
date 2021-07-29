package org.cis120;

import java.util.LinkedList;

public class Board {
    private int numRows;
    private int numCols;
    private Cell[][] cells;
    private PowerUp fd = new Food(300, 300, 600, 600);
    private PowerUp ss = new ShrinkSnake(100, 100, 600, 600);
    //private PowerUp rd = new ReverseDrxn(500, 500, 600, 600);

    public Board(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;

        cells = new Cell[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public int getNumRows() {
        return this.numRows;
    }

    public int getNumCols() {
        return this.getNumCols();
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void updateSnake(Snake sk) {

        LinkedList<SnakeBody> snake = sk.getSnake();

        for (SnakeBody sb : snake) {
            for (int row = 0; row < cells.length; row++) {
                for (int col = 0; col < cells.length; col++) {
                    if (sb.getPx() / 20 >= 0 && sb.getPy() >= 0 && sb.getPx() / 20 == col
                            && sb.getPy() / 20 == row) {
                        cells[row][col].setCellType(CellType.SNAKE_PART);
                    } else {
                        cells[row][col].setCellType(CellType.EMPTY);
                    }
                }
            }
        }
    }

    public void updateFood() {
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                if (fd.getPx() / 20 == col
                        && fd.getPy() / 20 == row) {
                    cells[row][col].setCellType(CellType.POWER_UP);
                } else {
                    cells[row][col].setCellType(CellType.EMPTY);
                }
            }
        }

    }

//    public void updateReverse() {
//        for (int row = 0; row < cells.length; row++) {
//            for (int col = 0; col < cells.length; col++) {
//                if (rd.getPx() / 20 == col
//                        && rd.getPy() / 20 == row) {
//                    cells[row][col].setCellType(CellType.POWER_UP);
//                } else {
//                    cells[row][col].setCellType(CellType.EMPTY);
//                }
//            }
//        }
//    }

    public void updateShrink() {
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                if (ss.getPx() / 20 == col
                        && ss.getPy() / 20 == row) {
                    cells[row][col].setCellType(CellType.POWER_UP);
                } else {
                    cells[row][col].setCellType(CellType.EMPTY);
                }
            }
        }
    }

    public void generateFood() {
        while (true) {
            int row = (int) (Math.random() * numRows);
            int col = (int) (Math.random() * numCols);
            if (cells[row][col].getCellType() == CellType.EMPTY) {
                this.fd = new Food((col * 20), (row * 20), 600, 600);
                break;
            }
        }
    }

    public void generatePoison() {
        while (true) {
            int row = (int) (Math.random() * numRows);
            int col = (int) (Math.random() * numCols);
            if (cells[row][col].getCellType() == CellType.EMPTY) {
                this.ss = new ShrinkSnake((col * 20), (row * 20), 600, 600);
                break;
            }
        }
    }

//    public void generateReverse() {
//        while (true) {
//            int row = (int) (Math.random() * numRows);
//            int col = (int) (Math.random() * numCols);
//            if (cells[row][col].getCellType() == CellType.EMPTY) {
//                this.rd = new ReverseDrxn((col * 20), (row * 20), 600, 600);
//                break;
//            }
//        }
//    }

    public ShrinkSnake getShrink() {
        return (ShrinkSnake) this.ss;
    }

    public Food getFood() {
        return (Food) this.fd;
    }

//    public PowerUp getRd() {
//        return (ReverseDrxn) this.rd;
//    }

}
