package services;

import exceptions.InvalidOrderException;
import exceptions.PaymentException;
import models.Order;
import payments.Payment;
import utils.AppConfig;

public class OrderService {
    // Attempt to create AppConfig directly using new.
    // AppConfig appConfig = new AppConfig();

    AppConfig appConfig = AppConfig.getInstance();
    Payment payment;

    public void processPayment(Payment payment) {
        payment.pay();
    }

    public void processOrder(Order order, Payment payment, double amountPaid) throws InvalidOrderException, PaymentException {
        // 1. Condition: an order containing no food items
        if(order.getFoodItems() == null || order.getFoodItems().length == 0) {
            throw new InvalidOrderException("Order #" + order.getOrderId() + " contains no food items!");
        }

        // 2. Condition: an order exceeding the maximum item count
        if (order.getFoodItems().length > AppConfig.getMaxItemsPerOrder()) {
            throw new InvalidOrderException("Order #" + order.getOrderId() 
                + " exceeds the maximum limit of " + AppConfig.getMaxItemsPerOrder() + " items!");
        }

        // 3. Condition: attempting to process an already completed order
        if (order.isCompleted()) {
            throw new InvalidOrderException("Order #" + order.getOrderId() + " is already completed!");
        }

        // 4. Condition: an invalid payment amount (less than order total or <= 0)
        double totalDue = order.getTotal();
        if (amountPaid < totalDue || amountPaid <= 0) {
            throw new PaymentException("Payment failed! Amount paid (₹" + amountPaid 
                + ") is less than total due (₹" + totalDue + ")");
        }

        // If all validations pass:
        payment.pay();
        order.setCompleted(true);
        System.out.println("Order #" + order.getOrderId() + " processed successfully!\n");
    }
}
