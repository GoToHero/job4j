package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ArrayDublicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
    String[] input = {"Результат", "должен", "Результат", "быть", "без", "быть", "дубликатов"};
    String[] except = {"Результат", "должен", "быть", "без", "дубликатов"};
    ArrayDublicate arrayDublicate = new ArrayDublicate();
    String[] result = arrayDublicate.remove(input);
    assertThat(result, arrayContainingInAnyOrder(except));
    }

    @Test
    public void test() {
        String[] input = {"Результат", "Результат", "Результат", "Результат", "Результат", "Результат", "Результат"};
        String[] except = {"Результат"};
        ArrayDublicate arrayDublicate = new ArrayDublicate();
        String[] result = arrayDublicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(except));
    }
}
