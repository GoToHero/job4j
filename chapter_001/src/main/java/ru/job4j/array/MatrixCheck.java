package ru.job4j.array;
/**
 *  @author GoToHero
 *  @version $Id$
 *  @since 0.1
 */
public class MatrixCheck {

    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            //Задаем условие равенства вершин диагоналей.
            //Первая диагональ.
            for (int j = 1; j < data.length; j++) {
                if (data[i][j] != data[0][0] & data[data.length - 1][data.length - 1]
                & data[data.length - 1][0] & data[0][data.length - 1]) {
                    result = false;
                    break;
                }
            }
            //Вторая диагональ.
            for (int j = data.length - 2; j >= 0; j--) {
                if (data[i][j] != data[0][0] & data[data.length - 1][data.length - 1]
                        & data[data.length - 1][0] & data[0][data.length - 1]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
