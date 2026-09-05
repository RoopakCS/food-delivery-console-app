package models;

public class User {
    int id;
    String name;
    String phone;
    
    public User(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public void displayRole() {
        System.out.println("I am a User");
    }
}
