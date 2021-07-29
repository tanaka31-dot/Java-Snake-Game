package org.cis120;

public class Cell {
    private final int row;
    private final int col;
    private CellType cellType;

    public Cell(int row, int col) {

        this.row = row;
        this.col = col;
        this.cellType = CellType.EMPTY;

    }

    public CellType getCellType() {
        return this.cellType;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

}
