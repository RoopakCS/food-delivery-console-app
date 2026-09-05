package models;

public class Order {
    int orderId;
    Customer customer;
    Restaurant restaurant;
    FoodItem[] foodItems;

    public Order() {}

    public Order(Customer customer, Restaurant restaurant) {
        this(0, customer, restaurant, null);
    }

    public Order(int orderId, Customer customer, Restaurant restaurant, FoodItem[] foodItems) {
        this.orderId = orderId;
        this.customer = customer;
        this.restaurant = restaurant;
        this.foodItems = foodItems;
    }
}
