package ru.job4j.tracker;

public class FindAllItem implements UserAction {

    @Override
    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Show all Items --------------");
        Item[] result = tracker.findAll();
        for (int index = 0; index < result.length; index++) {
            if (result[index] != null) {
                System.out.println(result[index]);
            }
        }
    }

    @Override
    public String info() {
        return "1. All Items.";
    }
}
