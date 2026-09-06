package models;

import interfaces.Discountable;

public class FoodItem implements Discountable, Cloneable {
    int id;
    String name;
    public double price;

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

    @Override
    public double calculateDiscount() {
        return price * 0.10;
    }

    @Override
    public FoodItem clone() {
        try {
            return (FoodItem) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "FoodItem [id=" + id + ", name=" + name + ", price=₹" + price + "]";
    }
}
