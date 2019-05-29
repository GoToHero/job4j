package ru.job4j.tracker;

public class ExitProgram extends BaseAction {

    private StartUI ui;

    public ExitProgram(int key, String name) {
        super(key, name);
    }

    ExitProgram(int key, String name, StartUI ui) {
        super(key, name);
        this.ui = ui;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Exit from program --------------");
        this.ui.stop();
    }
}
