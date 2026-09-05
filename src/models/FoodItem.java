package models;

public class FoodItem {
    int id;
    String name;
    double price;

    public FoodItem(String name) {
        this(0, name, 0.0);
    }

    public FoodItem(String name, double price) {
        this(0, name, price);
    }

    public FoodItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
