package ru.job4j.pseudo;

public class Paint {
    private Shape shape;

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
