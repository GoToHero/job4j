package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;
    private static final int START = 1;
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean overlapX(int x, int y, int match, int deltaX, int deltaY) {
        boolean result = false;
        if (match == 3) {
            result = true;
        }
        else {
            if (x + deltaX < this.table.length && y + deltaY < this.table.length &&
                    this.table[x][y].hasMarkX() == this.table[x + deltaX][y + deltaY].hasMarkX()) {
                result = this.overlapX(x + deltaX, y + deltaY, match + 1, deltaX, deltaY);
            }
        }
        return result;
    }

    public boolean overlapO(int x, int y, int match, int deltaX, int deltaY) {
        boolean result = false;
        if (match == 3) {
            result = true;
        }
        else {
            if (x + deltaX < this.table.length && y + deltaY < this.table.length &&
                    this.table[x][y].hasMarkO() == this.table[x + deltaX][y + deltaY].hasMarkO()) {
                result = this.overlapO(x + deltaX, y + deltaY, match + 1, deltaX, deltaY);
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        boolean result = false;
        for (int x = 0; x < this.table.length; x++) {
            for (int y = 0; y < this.table.length; y++) {
                if (this.overlapX(x, y, START, 0, 1) ||
                        this.overlapX(x, y, START, 1, 0) ||
                        this.overlapX(x, y, START, 1, 1)) {
                    result = true;
                    break;
                }
            }

        }
        return result;
    }

    public boolean isWinnerO() {
        boolean result = false;
        for (int x = 0; x < this.table.length; x++) {
            for (int y = 0; y < this.table.length; y++) {
                if (this.overlapO(x, y, START, 0, 1) ||
                        this.overlapO(x, y, START, 1, 0) ||
                        this.overlapO(x, y, START, 1, 1)) {
                    result = true;
                    break;
                }
            }

        }
        return result;
    }

    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < this.table.length - 1; i++) {
            for (int j = 0; j < this.table.length - 1; j++) {
                if (!this.table[i][j].hasMarkX() && !this.table[i][j].hasMarkO()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}