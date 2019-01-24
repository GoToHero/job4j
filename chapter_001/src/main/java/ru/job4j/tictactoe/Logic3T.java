package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Метод результат которого значение типа byte. Если byte = 1 - выиграли крестики.
     * Если 2, то нолики.
     * @return значение определяющее однотипный ряд клеток.
     */
    public byte overlap() {
        byte result = 0;
        int xStripeX;
        int yStripeX;
        int downDiagStripeX;
        int upDiagStripeX;
        int xStripeO;
        int yStripeO;
        int downDiagStripeO;
        int upDiagStripeO;
        for (int i = 0; i < this.table.length; i++) {
            xStripeX = 0;
            yStripeX = 0;
            downDiagStripeX = 0;
            upDiagStripeX = 0;
            xStripeO = 0;
            yStripeO = 0;
            downDiagStripeO = 0;
            upDiagStripeO = 0;
            for (int j = 0; j < this.table.length; j++) {
                if (this.table[i][j].hasMarkX()) {
                    xStripeX++;
                } else if (this.table[i][j].hasMarkO()) {
                    xStripeO++;
                }
                if (this.table[j][i].hasMarkX()) {
                    yStripeX++;
                } else if (this.table[j][i].hasMarkO()) {
                    yStripeO++;
                }
            }
            if (this.table[i][i].hasMarkX()) {
                downDiagStripeX++;
            } else if (this.table[i][i].hasMarkO()) {
                downDiagStripeO++;
            }
            if (this.table[i][this.table.length - i - 1].hasMarkX()) {
                upDiagStripeX++;
            } else if (this.table[i][this.table.length - i - 1].hasMarkO()) {
                upDiagStripeO++;
            }
            if (xStripeX == this.table.length || yStripeX == this.table.length
                    || downDiagStripeX == this.table.length || upDiagStripeX == this.table.length) {
                result = 1;
                break;
            } else if (xStripeO == this.table.length || yStripeO == this.table.length
                    || downDiagStripeO == this.table.length || upDiagStripeO == this.table.length) {
                result = 2;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        boolean result = false;
        if (this.overlap() == 1) {
            result = true;
        }
        return result;
    }

    public boolean isWinnerO() {
        boolean result = false;
        if (this.overlap() == 2) {
            result = true;
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

