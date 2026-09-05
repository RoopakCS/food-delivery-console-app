package models;

public class Address {
    int doorNumber;
    String street;
    String city;
    int pincode;

    public Address(String street, int pincode) {
        this(0, street, "Chennai", pincode);
    }

    public Address(int doorNumber, String street, String city, int pincode) {
        this.doorNumber = doorNumber;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
    }
}