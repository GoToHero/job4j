package ru.job4j.tracker;

public enum TrackerSingleEagerEnum {
    INSTANCE;

    public Item init (Item model) {
        return model;
    }
}