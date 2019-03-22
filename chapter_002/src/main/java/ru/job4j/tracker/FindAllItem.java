package ru.job4j.tracker;

public class FindAllItem implements UserAction {

    private int key;
    private String name;

    public FindAllItem(int key, String name) {
        this.key = key;
        this.name = name;
    }

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
        return String.format("%d. %s", key, name);
    }
}
