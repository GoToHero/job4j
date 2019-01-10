package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        boolean result = true;
        for (int i = 0; i < this.table.length - 1; i++) {
            for (int j = 0; j < this.table.length - 1; j++) {
                if (this.table[i][j].hasMarkX() != this.table[i][j + 1].hasMarkX()) {
                    result = false;
                    break;
                }
            }
        }
        if (!result) {
            for (int i = 0; i < this.table.length - 1; i++) {
                for (int j = 0; j < this.table.length - 1; j++) {
                    if (this.table[j][i].hasMarkX() != this.table[j + 1][i].hasMarkX()) {
                        result = false;
                        break;
                    }
                }
            }
        }
        if (!result) {
            for (int i = 0; i < this.table.length - 1; i++) {
                if (this.table[i][i].hasMarkX() != this.table[i + 1][i + 1].hasMarkX()
                        && this.table[this.table.length - 1 - i][i].hasMarkX() != this.table[this.table.length - 2 - i][i + 1].hasMarkX()) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public boolean isWinnerO() {
        boolean result = true;
        for (int i = 0; i < this.table.length - 1; i++) {
            for (int j = 0; j < this.table.length - 1; j++) {
                if (this.table[i][j].hasMarkO() != this.table[i][j + 1].hasMarkO()) {
                    result = false;
                    break;
                }
            }
        }
        if (!result) {
            for (int i = 0; i < this.table.length - 1; i++) {
                for (int j = 0; j < this.table.length - 1; j++) {
                    if (this.table[j][i].hasMarkO() != this.table[j + 1][i].hasMarkO()) {
                        result = false;
                        break;
                    }
                }
            }
        }
        if (!result) {
            for (int i = 0; i < this.table.length - 1; i++) {
                if (this.table[i][i].hasMarkO() != this.table[i + 1][i + 1].hasMarkO()
                        || this.table[this.table.length - 1 - i][i].hasMarkO() != this.table[this.table.length - 2 - i][i + 1].hasMarkO()) {
                    result = false;
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