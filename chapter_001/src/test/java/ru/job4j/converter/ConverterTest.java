package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    @Test
    public void when68RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(68);
        assertThat(result, is(1));
    }

    @Test
    public void when79RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(79);
        assertThat(result, is(1));
    }

    @Test
    public void when1EuroToRubleThen79() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(1);
        assertThat(result, is(79));
    }

    @Test
    public void when1DollarToRubleThen68() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(1);
        assertThat(result, is(68));
    }
}