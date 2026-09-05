package utils;

public class AppConfig {
    private static String appName = "FoodDeliveryApp";
    private static double deliveryCharge = 50;
    private static int numberOfOrders = 0;
    
    public static String getAppName() {
        return appName;
    }
    public static double getDeliveryCharge() {
        return deliveryCharge;
    }
    public static int getNumberOfOrders() {
        return numberOfOrders;
    }

    public static void setDeliveryCharge(double newDeliveryCharge) {
        AppConfig.deliveryCharge = newDeliveryCharge;
    }

    public static void incrementOrderCount() {
        AppConfig.numberOfOrders += 1;
    }
}
