package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        this.validates.forEach(invalid -> action.accept(invalid));

        /*int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);*/
        return  value;
    }

    private final List<Consumer<String>> validates = Arrays.asList(
            invalid -> {
                if (!invalid) {
                    throw new MenuOutException("Please select key from menu.");
                }
            },
            invalid -> {
                if (!invalid) {
                    throw new NumberFormatException("Please enter validate data again.");
                }
            }
    );
}
