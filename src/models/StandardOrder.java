package models;

import utils.AppConfig;

public class StandardOrder extends DeliveryOrder {

    public StandardOrder(int orderId, Customer customer, Restaurant restaurant) {
        super(orderId, customer, restaurant);
    }

    @Override
    public double calculateDeliveryFee() {
        return AppConfig.getDeliveryCharge();
    }
}
