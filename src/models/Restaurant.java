  package models;
    
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public int id;
    public String name;
    public String location;
    private List<FoodItem> menu = new ArrayList<>();

    public Restaurant(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public void addMenuItem(FoodItem item) {
        menu.add(item);
    }

    public List<FoodItem> getMenu() {
        return menu;
    }

    public void displayMenu() {
        System.out.println("\n--- Menu for " + name + " ---");
        for (FoodItem item : menu) {
            System.out.println(item);
        }
    }
}