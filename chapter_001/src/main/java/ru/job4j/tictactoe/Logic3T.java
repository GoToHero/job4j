package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        boolean result = false;
        for (int i = 0; i < this.table.length - 1; i++) {
            for (int j = 0; j < this.table.length - 1; j++) {
                if (this.table[i][j] != this.table[i][j + 1]
                        || this.table[j][i] != this.table[j + 1][i]
                        || this.table[i][i] != this.table[i + 1][i + 1]
                        || this.table[this.table.length - 1 - i][i] != this.table[this.table.length - 2 - i][i + 1]) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public boolean isWinnerO() {
        boolean result = false;
        for (int i = 0; i < this.table.length - 1; i++) {
            for (int j = 0; j < this.table.length - 1; j++) {
                if (this.table[i][j] != this.table[i][j + 1]
                        || this.table[j][i] != this.table[j + 1][i]
                        || this.table[i][i] != this.table[i + 1][i + 1]
                        || this.table[this.table.length - 1 - i][i] != this.table[this.table.length - 2 - i][i + 1]) {
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
                if (this.table[i][j] != this.table[i][j + 1]
                        || this.table[j][i] != this.table[j + 1][i]
                        || this.table[i][i] != this.table[i + 1][i + 1]
                        || this.table[this.table.length - 1 - i][i] != this.table[this.table.length - 2 - i][i + 1]) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}