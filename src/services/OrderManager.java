package services;

import java.util.ArrayList;
import java.util.List;

import models.Order;

public class OrderManager {
    // Dynamic collection to hold orders
    private List<Order> orders = new ArrayList<>();

    // 1. Add order
    public void addOrder(Order order) {
        orders.add(order);
    }

    // 2. Remove order by ID
    public boolean removeOrder(int orderId) {
        Order orderToRemove = findOrderById(orderId);
        if (orderToRemove != null) {
            orders.remove(orderToRemove);
            System.out.println("Order #" + orderId + " was successfully removed.");
            return true;
        }
        System.out.println("Order #" + orderId + " not found for removal.");
        return false;
    }

    // 3. Find order by ID
    public Order findOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    // 4. Display all orders
    public void displayAllOrders() {
        System.out.println("\n--- All Orders in System ---");
        if (orders.isEmpty()) {
            System.out.println("No active orders.");
            return;
        }
        for (Order order : orders) {
            order.displayOrderInfo();
        }
    }

    // 5. Check number of orders
    public int getOrderCount() {
        return orders.size();
    }

    // Helper for testing indexed access
    public Order getOrderByIndex(int index) {
        return orders.get(index);
    }
}
