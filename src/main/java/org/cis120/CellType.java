package org.cis120;

public enum CellType {

    EMPTY(" "),
    POWER_UP("@"),
    SNAKE_PART("o");

    private String string;

    CellType(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }

}
