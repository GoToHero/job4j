package ru.job4j.tracker;

public class ExitProgram implements UserAction {

    private int key;
    private String name;

    public ExitProgram(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Exit from program --------------");
    }

    @Override
    public String info() {
        return String.format("%d. %s,", key, name);
    }
}
