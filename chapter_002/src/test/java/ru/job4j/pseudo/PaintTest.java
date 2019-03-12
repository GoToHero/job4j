package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
    //дефолтный вывод на консоль
    private final PrintStream sdout = System.out;
    //буфер для результата
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.sdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        // проверяем результат вычисления
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append("+  +")
                                .append("+  +")
                                .append("++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        // проверяем результат вычисления
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("  +  ")
                                .append(" +++ ")
                                .append("+++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}