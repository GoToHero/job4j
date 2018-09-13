package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
    Counter sumNumbers = new Counter();
    int result = sumNumbers.add(1, 10);
    assertThat(result, is(30));
    }
}

