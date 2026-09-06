package models;

import interfaces.*;

public class SpecialOrder implements Trackable, Discountable {
    String name;
    double price;
    int orderId;

    public SpecialOrder(int orderId, String name, double price) {
        this.orderId = orderId;
        this.name = name;
        this.price = price;
    }

    @Override
    public String trackOrder() {
        return "Special Order #" + orderId + " (" + name + ") is on its way!";
    }

    @Override
    public double calculateDiscount() {
        return price * 0.20;  // 20% discount for special orders
    }
}