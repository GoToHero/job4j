package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void distanceAtoB() {
        Point A = new Point(0,1);
        Point B = new Point(2,5);
        double distance = A.distanceTo(B);
        assertThat(distance, closeTo(4.5, 0.1));
    }

    @Test
    public void distanceAtoC() {
        Point A = new Point(0,1);
        Point C = new Point(7,-8);
        double distance = A.distanceTo(C);
        assertThat(distance, closeTo(11.4, 0.1));
    }

    @Test
    public void distanceBtoC() {
        Point B = new Point(2,5);
        Point C = new Point(7,-8);
        double distance = B.distanceTo(C);
        assertThat(distance, closeTo(13.9, 0.1));
    }
}