package models;

import utils.AppConfig;

public class Order {
    private int orderId;
    private Customer customer;
    private Restaurant restaurant;
    private FoodItem[] foodItems;

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

    // Getters

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public FoodItem[] getFoodItems() {
        return foodItems;
    }

    // Method for retrieving the current total

    public double getTotal() {
        double sum = 0;

        if(foodItems != null) {
            for(FoodItem item: foodItems) {
                sum += item.price;
            }
        }

        return sum + AppConfig.getDeliveryCharge();
    }

    // To Prevent an order from accepting more than the configured maximum number of items

    public void addItem(FoodItem item) {
        if (foodItems != null && foodItems.length >= AppConfig.getMaxItemsPerOrder()) {
            System.out.println("Cannot add more items. Maximum limit of " + AppConfig.getMaxItemsPerOrder() + " reached.");
            return;
        }
    
        if (foodItems == null) {
            foodItems = new FoodItem[]{item};
        } else {
            FoodItem[] newItems = new FoodItem[foodItems.length + 1];
            for (int i = 0; i < foodItems.length; i++) {
                newItems[i] = foodItems[i];
            }
            newItems[foodItems.length] = item;
            foodItems = newItems;
        }
    }

    // Method for displaying the order

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

        System.out.println("Total (incl. delivery charge): ₹" + getTotal());
        System.out.println("Delivery Charge: ₹" + AppConfig.getDeliveryCharge());
    }

    
}
