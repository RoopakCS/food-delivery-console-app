package utils;

public class AppConfig {
    private static String appName = "FoodDeliveryApp";
    private static double deliveryCharge = 50;
    private static int numberOfOrders = 0;
    private static int maxItemsPerOrder = 10;

    // Make AppConfig a Singleton class.
    private static AppConfig appConfig;

    private AppConfig() {}

    public static AppConfig getInstance() {
        if(appConfig == null) {
            appConfig = new AppConfig();
        }

        return appConfig;
    }
    
    // Getters
    public static String getAppName() {
        return appName;
    }
    
    public static double getDeliveryCharge() {
        return deliveryCharge;
    }
    
    public static int getNumberOfOrders() {
        return numberOfOrders;
    }

    public static int getMaxItemsPerOrder() {
        return maxItemsPerOrder;
    }

    // Setters
    public static void setDeliveryCharge(double newDeliveryCharge) {
        AppConfig.deliveryCharge = newDeliveryCharge;
    }

    public static void incrementOrderCount() {
        AppConfig.numberOfOrders += 1;
    }

}
