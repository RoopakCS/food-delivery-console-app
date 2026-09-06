package app;

import exceptions.InvalidOrderException;
import exceptions.PaymentException;
import interfaces.Discountable;
import interfaces.Trackable;
import models.*;
import payments.*;
import repository.Repository;
import services.OrderManager;
import services.OrderService;
import services.RestaurantService;
import utils.AppConfig;
import utils.Pair;

public class Main {
    public static void main(String[] args) {
        // AppConfig
        
        System.out.println("========================================");
        System.out.println("App: " + AppConfig.getAppName());
        
        // Customers
        
        // Customer roopak = new Customer(1, "Roopak", "9994454835", new Address(254, "Senthamil Nagar", "Ramanathapuram", 623536));

        // Customer madhu = new Customer(2, "Madhu Bashini", "7358115463", new Address(143, "Latheef Castle", "Ambattur", 600032));
        
        // // Restaurants

        // Restaurant geetham = new Restaurant(1, "Geetham", "Ambattur");
        // Restaurant sangeetha = new Restaurant(2, "Sangeetha", "Anna Nagar");
        
        // // Food items

        // FoodItem vegBriyani = new FoodItem(1, "Veg Briyani", 60);
        // FoodItem gobiFriedRice = new FoodItem(2, "Gobi Fried Rice", 100);
        // FoodItem gobi65 = new FoodItem(3, "Gobi 65", 40);
        // FoodItem pongal = new FoodItem(4, "Pongal", 60);
        // FoodItem sambarVada = new FoodItem(5, "Sambar Vada", 30);
        
        // FoodItem water = new FoodItem("Water");
        // FoodItem dosa = new FoodItem("Dosa", 45);
        
        // // Orders

        // Order roopakOrder = new Order(1, roopak, geetham, new FoodItem[]{sambarVada, vegBriyani});
        // Order madhuOrder = new Order(madhu, sangeetha);
        
        // roopakOrder.displayOrderInfo();
        // madhuOrder.displayOrderInfo();
        
        // System.out.println("========================================");
        
        // System.out.println("Total Orders Created: " + AppConfig.getNumberOfOrders());
        
        // System.out.println("========================================");

        // Restaurant onwer

        // RestaurantOwner gordan = new RestaurantOwner(1, "Gordan Ramsay", "9786756456");
        
        // roopak.displayRole();
        // gordan.displayRole();

        // Payment cardPayment = new CardPayment();
        // Payment upiPayment = new UPIPayment();
        // Payment cashPayment = new CashPayment();

        // OrderService orderService = new OrderService();
        // orderService.processPayment(cashPayment);
        // orderService.processPayment(upiPayment);
        // orderService.processPayment(cardPayment);

        // RestaurantService restaurantService = new RestaurantService();

        // restaurantService.searchRestaurant("Geetham");
        // restaurantService.searchRestaurant("Geetham", "Chennai");
        // restaurantService.searchRestaurant("Geetham", "Chennai", 2);

        // Delivery order

        // DeliveryOrder standardOrder = new StandardOrder(0, madhu, sangeetha);
        // standardOrder.displayOrderInfo();

        // DeliveryOrder expressOrder = new ExpressOrder(1, roopak, geetham);
        // expressOrder.displayOrderInfo();

        // Interfaces

        // Trackable trackableOrder = roopakOrder;
        // System.out.println(trackableOrder.trackOrder());

        // Discountable discountableItem = vegBriyani;
        // System.out.println("Discount: ₹" + discountableItem.calculateDiscount());

        // SpecialOrder specialOrder = new SpecialOrder(1, "Festival Combo", 500);

        // Trackable splTrackable = specialOrder;
        // Discountable spDiscountable = specialOrder;

        // System.out.println(splTrackable.trackOrder());
        // System.out.println("Discount: ₹" + spDiscountable.calculateDiscount());

        // Overriding toString()

        // System.out.println(roopak);

        // Object cloning

        // FoodItem originalCB = new FoodItem("Chicken Briyani", 220);

        // FoodItem clonedCB = originalCB.clone();

        // System.out.println("--- Before Modification ---");
        // System.out.println("Original: " + originalCB);
        // System.out.println("Clone   : " + clonedCB);

        // clonedCB.price = 250; 

        // System.out.println("\n--- After Modifying Clone's Price to ₹250 ---");
        // System.out.println("Original: " + originalCB);
        // System.out.println("Clone   : " + clonedCB);

        // System.out.println("\nAre they the exact same object in memory (==)? " + (originalCB == clonedCB));

        // Repository

        // --- 1. Customer Repository ---
        // Repository<Customer> customerRepo = new Repository<>();
        // Customer c1 = new Customer(1, "Arun", "9876543210", new Address(12, "Anna St", "Chennai", 600001));
        // Customer c2 = new Customer(2, "Meena", "9876543211", new Address(45, "Gandhi Rd", "Chennai", 600002));
        // Customer c3 = new Customer(3, "Karthik", "9876543212", new Address(78, "Main Rd", "Chennai", 600003));
        
        // customerRepo.addObject(c1);
        // customerRepo.addObject(c2);
        // customerRepo.addObject(c3);

        // // --- 2. Restaurant Repository ---
        // Repository<Restaurant> restaurantRepo = new Repository<>();
        // Restaurant r1 = new Restaurant(101, "Chennai Spice", "T. Nagar");
        // Restaurant r2 = new Restaurant(102, "Anjappar", "Anna Nagar");
        
        // restaurantRepo.addObject(r1);
        // restaurantRepo.addObject(r2);

        // // --- 3. FoodItem Repository ---
        // Repository<FoodItem> foodItemRepo = new Repository<>();
        // foodItemRepo.addObject(new FoodItem(1, "Chicken Biryani", 220));
        // foodItemRepo.addObject(new FoodItem(2, "Paneer Rice", 180));
        // foodItemRepo.addObject(new FoodItem(3, "Fresh Lime", 60));
        // foodItemRepo.addObject(new FoodItem(4, "Dosa", 50));
        // foodItemRepo.addObject(new FoodItem(5, "Parotta", 40));

        // // --- 4. Order Repository ---
        // Repository<Order> orderRepo = new Repository<>();
        // orderRepo.addObject(new Order(1, c1, r1, new FoodItem[]{foodItemRepo.getObject(0), foodItemRepo.getObject(2)}));
        // orderRepo.addObject(new Order(2, c2, r2, new FoodItem[]{foodItemRepo.getObject(1)}));
        // orderRepo.addObject(new Order(3, c3, r1, new FoodItem[]{foodItemRepo.getObject(3), foodItemRepo.getObject(4)}));

        // // --- Display Size and Items ---
        // System.out.println("Total Customers: " + customerRepo.size());
        // for (Customer c : customerRepo.getAllObjects()) {
        //     System.out.println("Customer: " + c);
        // }

        // System.out.println("\nTotal Restaurants: " + restaurantRepo.size());
        // for (Restaurant r : restaurantRepo.getAllObjects()) {
        //     System.out.println("Restaurant: " + r);
        // }

        // System.out.println("\nTotal Food Items: " + foodItemRepo.size());
        // for (FoodItem f : foodItemRepo.getAllObjects()) {
        //     System.out.println("Item: " + f);
        // }

        // System.out.println("\nTotal Orders: " + orderRepo.size());
        // for (Order o : orderRepo.getAllObjects()) {
        //     o.displayOrderInfo();
        // }

        // Pairs

        // // 1. Restaurant ID and Restaurant Name
        // Pair<Integer, String> restaurantPair = new Pair<>(101, "Chennai Spice");

        // // 2. Customer ID and Customer Name
        // Pair<Integer, String> customerPair = new Pair<>(1, "Arun Kumar");

        // // 3. Order ID and Order Status (using String or an Enum)
        // Pair<Integer, String> orderStatusPair = new Pair<>(1001, "DELIVERED");

        // // 4. Bonus: Different type combination (e.g. FoodItem name and Price)
        // Pair<String, Double> foodPricePair = new Pair<>("Chicken Biryani", 220.0);

        // // Display the values
        // System.out.println("Restaurant Pair: " + restaurantPair.getKey() + " = " + restaurantPair.getValue());
        // System.out.println("Customer Pair  : " + customerPair.getKey() + " = " + customerPair.getValue());
        // System.out.println("Order Status   : " + orderStatusPair.getKey() + " = " + orderStatusPair.getValue());
        // System.out.println("Food Price     : " + foodPricePair.getKey() + " = ₹" + foodPricePair.getValue());

        // // Full toString output
        // System.out.println("\nFormatted Pairs:");
        // System.out.println(restaurantPair);
        // System.out.println(foodPricePair);

        // Exceptions

        // OrderService orderService = new OrderService();
        // Restaurant restaurant = new Restaurant(1, "Chennai Spice", "Anna Nagar");
        // Customer customer = new Customer(1, "Arun", "9876543210", new Address("MG Road", 600001));
        // Payment upi = new UPIPayment();

        // System.out.println("=== Starting Order Processing Tests ===\n");

        // // TEST 1: Empty food items
        // try {
        //     System.out.println("Test 1: Processing empty order...");
        //     Order emptyOrder = new Order(101, customer, restaurant, new FoodItem[]{});
        //     orderService.processOrder(emptyOrder, upi, 100);
        // } catch (InvalidOrderException | PaymentException e) {
        //     System.out.println("Handled Error: " + e.getMessage() + "\n");
        // }

        // // TEST 2: Invalid payment amount
        // try {
        //     System.out.println("Test 2: Processing order with insufficient payment...");
        //     FoodItem biryani = new FoodItem(1, "Biryani", 200);
        //     Order normalOrder = new Order(102, customer, restaurant, new FoodItem[]{biryani});
        //     // Total = 200 + delivery charge (50) = 250, but paying only 100
        //     orderService.processOrder(normalOrder, upi, 100);
        // } catch (InvalidOrderException | PaymentException e) {
        //     System.out.println("Handled Error: " + e.getMessage() + "\n");
        // }

        // // TEST 3: Already completed order
        // try {
        //     System.out.println("Test 3: Processing order twice...");
        //     FoodItem dosa = new FoodItem(2, "Dosa", 50);
        //     Order validOrder = new Order(103, customer, restaurant, new FoodItem[]{dosa});
        //     // First time - valid
        //     orderService.processOrder(validOrder, upi, 200);
        //     // Second time - triggers already completed error
        //     orderService.processOrder(validOrder, upi, 200);
        // } catch (InvalidOrderException | PaymentException e) {
        //     System.out.println("Handled Error: " + e.getMessage() + "\n");
        // }

        // System.out.println("=== Application finished safely without crashing! ===");

        Customer c1 = new Customer(1, "Arun", "9876543210", new Address("Street 1", 600001));
        Customer c2 = new Customer(2, "Meena", "9876543211", new Address("Street 2", 600002));
        
        Restaurant r1 = new Restaurant(1, "Chennai Spice", "Anna Nagar");
        FoodItem biryani = new FoodItem(1, "Biryani", 220);
        FoodItem paneer = new FoodItem(2, "Paneer Rice", 180);
        FoodItem lime = new FoodItem(3, "Fresh Lime", 50);
        
        // Menu collection test
        r1.addMenuItem(biryani);
        r1.addMenuItem(paneer);
        r1.addMenuItem(lime);
        r1.displayMenu();

        OrderManager manager = new OrderManager();

        // 1. Add 5 orders
        System.out.println("\n1. Adding 5 orders...");
        manager.addOrder(new Order(1001, c1, r1, new FoodItem[]{biryani}));
        manager.addOrder(new Order(1002, c2, r1, new FoodItem[]{paneer}));
        manager.addOrder(new Order(1003, c1, r1, new FoodItem[]{lime}));
        manager.addOrder(new Order(1004, c2, r1, new FoodItem[]{biryani, lime}));
        manager.addOrder(new Order(1005, c1, r1, new FoodItem[]{paneer, lime}));

        // 2. Display all orders
        System.out.println("\n2. Displaying all orders:");
        manager.displayAllOrders();

        // 3. Find order 1003
        System.out.println("\n3. Finding order 1003:");
        Order found = manager.findOrderById(1003);
        if (found != null) {
            System.out.println("Found Order #1003! Details:");
            found.displayOrderInfo();
        }

        // 4. Remove order 1002
        System.out.println("\n4. Removing order 1002:");
        manager.removeOrder(1002);

        // 5. Display the remaining orders
        System.out.println("\n5. Displaying remaining orders after removal:");
        manager.displayAllOrders();

        // 6. Add another order
        System.out.println("\n6. Adding order 1006...");
        manager.addOrder(new Order(1006, c2, r1, new FoodItem[]{biryani}));

        // 7. Display the new count
        System.out.println("\n7. Total Orders Count: " + manager.getOrderCount());

        // --- EXPERIMENT: Invalid indexed access ---
        System.out.println("\n--- Experiment: Testing Out-of-Bounds Index ---");
        try {
            manager.getOrderByIndex(99); // index 99 does not exist
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Handled expected error: Invalid index access: " + e.getMessage());
        }
    }
}
