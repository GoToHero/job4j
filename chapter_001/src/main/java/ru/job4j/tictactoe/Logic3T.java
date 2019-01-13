package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        boolean result = false;
        int xStripeX = 0;
        int yStripeX = 0;
        int downDiagStripeX = 0;
        int upDiagStripeX = 0;
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (this.table[i][j].hasMarkX()) {
                    xStripeX++;
                } else {
                    xStripeX = 0;
                }
                if (this.table[j][i].hasMarkX()) {
                    yStripeX++;
                } else {
                    yStripeX = 0;
                }
            }
            if (this.table[i][i].hasMarkX()) {
                downDiagStripeX++;
            } else {
                downDiagStripeX = 0;
            }
            if (this.table[i][this.table.length - i - 1].hasMarkX()) {
                upDiagStripeX++;
            } else {
                upDiagStripeX = 0;
            }
            if (xStripeX == this.table.length || yStripeX == this.table.length ||
                    downDiagStripeX == this.table.length || upDiagStripeX == this.table.length) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerO() {
        boolean result = false;
        int xStripeO = 0;
        int yStripeO = 0;
        int downDiagStripeO = 0;
        int upDiagStripeO = 0;
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (this.table[i][j].hasMarkO()) {
                    xStripeO++;
                } else {
                    xStripeO = 0;
                }
                if (this.table[j][i].hasMarkO()) {
                    yStripeO++;
                } else {
                    yStripeO = 0;
                }
            }
            if (this.table[i][i].hasMarkO()) {
                downDiagStripeO++;
            } else {
                downDiagStripeO = 0;
            }
            if (this.table[i][this.table.length - i - 1].hasMarkO()) {
                upDiagStripeO++;
            } else {
                upDiagStripeO = 0;
            }
            if (xStripeO == this.table.length || yStripeO == this.table.length ||
                    downDiagStripeO == this.table.length || upDiagStripeO == this.table.length) {
                result = true;
                break;
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