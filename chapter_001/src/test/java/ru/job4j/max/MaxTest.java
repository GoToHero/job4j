package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(-1, -6);
        assertThat(result, is(-1));
    }

    @Test
    public void whenAddThirdMax() {
        Max maxim = new Max();
        int result = maxim.max(-1, -6, 5);
        assertThat(result, is(5));
    }

    @Test
    public void whenThirdLessOthers() {
        Max maxim = new Max();
        int result = maxim.max(-1, -6, -10);
        assertThat(result, is(-1));
    }
}