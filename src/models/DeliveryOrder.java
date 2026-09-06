package models;

public abstract class DeliveryOrder {
    int orderId;
    Customer customer;
    Restaurant restaurant;

    public DeliveryOrder(int orderId, Customer customer, Restaurant restaurant) {
        this.orderId = orderId;
        this.customer = customer;
        this.restaurant = restaurant;
    }

    abstract double calculateDeliveryFee();

    public void displayOrderInfo() {
        System.out.println("Order ID: " + orderId);
        if (customer != null) System.out.println("Customer: " + customer.name);
        if (restaurant != null) System.out.println("Restaurant: " + restaurant.name);
        System.out.println("Delivery Fee: ₹" + calculateDeliveryFee());
    }
}
