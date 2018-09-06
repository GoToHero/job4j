package ru.job4j.condition;

/**
 * Программа для описания точки в двухмерной системе координат.
 */
public class Point {
    /**
     * Тип вовводимых значений - целое число.
     */
    private int x;
    private int y;

    /**
     * Метод для задания координат точки.
     * @param x запись координаты точки А по горизонтальной оси.
     * @param y запись координаты точки А по вертикальной оси.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод для вычисления расстояния от точки А до точки Б.
     * @param that координаты второй точки.
     * @return расстояние до точки.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

    /**
     * Задание конкретных точек и вывод результата на консоль.
     * За счёт ссылки метода distanceTo к объектам, мы получаем координату первой точки.
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        Point c = new Point(7, -8);
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);
        System.out.println("x3 = " + c.x);
        System.out.println("y3 = " + c.y);

        double resultToB = a.distanceTo(b);
        double resultToC = a.distanceTo(c);
        double resultBtoC = b.distanceTo(c);
        System.out.println("Расстояние между точками А и Б : " + resultToB);
        System.out.println("Расстояние между точками А и C : " + resultToC);
        System.out.println("Расстояние между точками Б и C : " + resultBtoC);
    }
}