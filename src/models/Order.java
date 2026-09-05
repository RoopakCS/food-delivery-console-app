package models;

import utils.AppConfig;

public class Order {
    int orderId;
    Customer customer;
    Restaurant restaurant;
    FoodItem[] foodItems;

    public Order(Customer customer, Restaurant restaurant) {
        this(0, customer, restaurant, null);
    }

    public Order(int orderId, Customer customer, Restaurant restaurant, FoodItem[] foodItems) {
        this.orderId = orderId;
        this.customer = customer;
        this.restaurant = restaurant;
        this.foodItems = foodItems;

        AppConfig.incrementOrderCount();
    }

    public void displayOrderInfo() {
        System.out.println("========================================");

        System.out.println("Order ID: " + this.orderId);
            
        if (customer != null) {
            System.out.println("Customer: " + customer.name);
        }
        if (restaurant != null) {
            System.out.println("Restaurant: " + restaurant.name + " (" + restaurant.location + ")");
        }
        
        if (foodItems != null && foodItems.length > 0) {
            System.out.println("Items:");
            for (FoodItem item : foodItems) {
                if (item != null) {
                    System.out.println("  - " + item.name + ": ₹" + item.price);
                }
            }
        }

        System.out.println("Delivery Charge: ₹" + AppConfig.getDeliveryCharge());
    }
}
