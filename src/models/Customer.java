package models;

public class Customer extends User {
    Address address;

    public Customer(int id, String name, String phone, Address address) {
        super(id, name, phone);
        this.address = address;
    }

    @Override 
    public void displayRole() {
        System.out.println("I am a Customer");
    }

    @Override
    public String toString() {
        return "I am " + name;
    }
}
