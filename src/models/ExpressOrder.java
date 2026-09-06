package models;

import utils.AppConfig;

public class ExpressOrder extends DeliveryOrder {

    public ExpressOrder(int orderId, Customer customer, Restaurant restaurant) {
        super(orderId, customer, restaurant);
    }

    @Override
    public double calculateDeliveryFee() {
        return AppConfig.getDeliveryCharge() * 1.5;
    }
    
}
