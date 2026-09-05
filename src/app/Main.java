package app;

import models.*;
import utils.AppConfig;

public class Main {
    public static void main(String[] args) {
        // AppConfig
        System.out.println("========================================");
        System.out.println("App: " + AppConfig.getAppName());
        
        Customer roopak = new Customer(1, "Roopak", "9994454835", new Address(254, "Senthamil Nagar", "Ramanathapuram", 623536));

        Customer madhu = new Customer(2, "Madhu Bashini", "7358115463", new Address(143, "Latheef Castle", "Ambattur", 600032));
        
        Restaurant geetham = new Restaurant(1, "Geetham", "Ambattur");
        Restaurant sangeetha = new Restaurant(2, "Sangeetha", "Anna Nagar");
        
        FoodItem vegBriyani = new FoodItem(1, "Veg Briyani", 60);
        FoodItem gobiFriedRice = new FoodItem(2, "Gobi Fried Rice", 100);
        FoodItem gobi65 = new FoodItem(3, "Gobi 65", 40);
        FoodItem pongal = new FoodItem(4, "Pongal", 60);
        FoodItem sambarVada = new FoodItem(5, "Sambar Vada", 30);
        
        FoodItem water = new FoodItem("Water");
        FoodItem dosa = new FoodItem("Dosa", 45);
        
        Order roopakOrder = new Order(1, roopak, geetham, new FoodItem[]{sambarVada, vegBriyani});
        Order madhuOrder = new Order(madhu, sangeetha);
        
        roopakOrder.displayOrderInfo();
        madhuOrder.displayOrderInfo();
        
        System.out.println("========================================");
        
        System.out.println("Delivery Charge: ₹" + AppConfig.getDeliveryCharge());
        System.out.println("Total Orders Created: " + AppConfig.getNumberOfOrders());
        
        System.out.println("========================================");
    }
}
