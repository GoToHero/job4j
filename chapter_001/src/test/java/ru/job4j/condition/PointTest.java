package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void distanceAtoB() {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        double distance = a.distanceTo(b);
        assertThat(distance, closeTo(4.5, 0.1));
    }

    @Test
    public void distanceAtoC() {
        Point a = new Point(0, 1);
        Point c = new Point(7, -8);
        double distance = a.distanceTo(c);
        assertThat(distance, closeTo(11.4, 0.1));
    }

    @Test
    public void distanceBtoC() {
        Point b = new Point(2, 5);
        Point c = new Point(7, -8);
        double distance = b.distanceTo(c);
        assertThat(distance, closeTo(13.9, 0.1));
    }
}