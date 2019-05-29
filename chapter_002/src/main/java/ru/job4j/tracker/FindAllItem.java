package ru.job4j.tracker;

public class FindAllItem extends BaseAction {

    public FindAllItem(int key, String name) {
        super(key, name);
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
}
