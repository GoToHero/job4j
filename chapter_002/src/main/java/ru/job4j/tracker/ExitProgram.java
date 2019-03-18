package ru.job4j.tracker;

public class ExitProgram implements UserAction{

    @Override
    public int key() {
        return EXIT;
    }

    @Override
    public String info() {
        return "Exit program.";
    }
}
