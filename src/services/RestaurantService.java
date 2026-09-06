package services;

import utils.AppConfig;

public class RestaurantService {
    // Attempt to create AppConfig directly using new.
    // AppConfig appConfig = new AppConfig();

    AppConfig appConfig = AppConfig.getInstance();

    public void searchRestaurant(String name) {
        System.out.println("Searching for " + name + " restaurant");
    } 
    
    public void searchRestaurant(String name, String city) {
        System.out.println("Searching for " + name + " restaurant in " + city);
    }
    
    public void searchRestaurant(String name, String city, int maxDeliveryTime) {
        System.out.println("Searching for " + name + " restaurant in " + city + " with maximum delivery time " + maxDeliveryTime);
    }
}
