package services;

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
}
