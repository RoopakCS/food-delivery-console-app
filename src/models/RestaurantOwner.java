package models;

public class RestaurantOwner extends User {
    
    public RestaurantOwner(int id, String name, String phone) {
        super(id, name, phone);
    }

    @Override 
    public void displayRole() {
        System.out.println("I am a Restaurant Owner");
    }
}
