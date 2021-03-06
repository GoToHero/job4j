package ru.job4j.tracker;

public class Item {

    public String id;
    public String name;
    public String description;
    public long create;

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return this.create;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Item [ItemID=" + id + ", Name=" + name + ", Description=" + description + "]";
    }

    public void setId(String id) {
        this.id = id;
    }
}
