# Final Practical Exercise: Console-Based Food Delivery System

Build a **console-based Food Delivery System** for a small restaurant platform.

The application should allow customers to browse restaurants, add food items to an order, choose different payment methods, calculate the bill, and display the final order.

You are not building a production application. The goal is to use the Java OOP concepts from the entire playlist in one coherent program.

---

## Package Structure

Create the project with this package structure:

```text
FoodDeliveryApp/
│
├── src/
│   │
│   ├── app/
│   │   └── Main.java
│   │
│   ├── models/
│   │   ├── User.java
│   │   ├── Customer.java
│   │   ├── Restaurant.java
│   │   ├── FoodItem.java
│   │   ├── Order.java
│   │   └── Address.java
│   │
│   ├── payments/
│   │   ├── Payment.java
│   │   ├── CardPayment.java
│   │   ├── UPIPayment.java
│   │   └── CashPayment.java
│   │
│   ├── services/
│   │   ├── OrderService.java
│   │   └── RestaurantService.java
│   │
│   ├── exceptions/
│   │   ├── InvalidOrderException.java
│   │   └── PaymentException.java
│   │
│   ├── utils/
│   │   └── AppConfig.java
│   │
│   └── enums/
│       ├── OrderStatus.java
│       └── PaymentStatus.java
```

Do not use a framework.

Use normal Java packages and `import` statements.

---

# Exercise 1: Create the Basic Domain Model

**Task**

Create the basic classes required for the application.

The system needs to represent customers, restaurants, food items, addresses, and orders.

**Requirements**

* Create `User`.
* Give it:

  * `id`
  * `name`
  * `phone`
* Create `Customer` that extends `User`.
* Give `Customer` an `address`.
* Create `Address` with:

  * `doorNumber`
  * `street`
  * `city`
  * `pincode`
* Create `Restaurant` with:

  * `id`
  * `name`
  * `location`
* Create `FoodItem` with:

  * `id`
  * `name`
  * `price`
* Create `Order` with:

  * `orderId`
  * customer
  * restaurant
  * food items
* Use constructors to initialize the objects.
* Use `this` wherever appropriate when constructor parameters have the same names as instance fields.
* Create at least:

  * 2 customers
  * 2 restaurants
  * 5 food items

**Test it**

Create:

* Customer: Arun
* Restaurant: Chennai Spice
* Food items:

  * Chicken Biryani: ₹220
  * Paneer Rice: ₹180
  * Fresh Lime: ₹60

Create an order for Arun containing all three items.

Print the customer's details, restaurant details, and ordered food items.

**Experiment**

Create two `FoodItem` objects with different names but the same price.

Then create two objects with the same name and price.

Compare the objects using `==`.

Then compare them using `equals()`.

Do not override `equals()` yet.

**Why questions**

1. Why does each `FoodItem` object maintain its own `name` and `price`?
2. Why does `this` refer to the current object inside a constructor?
3. Why are two objects with identical field values still separate objects?
4. What difference did you observe between `==` and `equals()`?

---

# Exercise 2: Constructors and Constructor Overloading

**Task**

Make the classes flexible enough to create objects using different amounts of information.

**Requirements**

* `FoodItem` must have a constructor accepting:

  * `id`
  * `name`
  * `price`
* Add another constructor accepting:

  * `name`
  * `price`
* Add another constructor that creates a food item with only:

  * `name`
* Decide appropriate default values for fields that were not supplied.
* Create overloaded constructors for `Address` as well.
* Create an `Order` constructor that can create:

  * an empty order
  * an order containing a customer and restaurant

**Test it**

Create food items using every available constructor.

Create addresses using at least two different constructors.

Create orders using the different constructors.

**Experiment**

Add a constructor to `FoodItem` that accepts a completely different parameter list.

Then attempt to create a food item using a combination of arguments that does not match any constructor.

Compile the program.

**Why questions**

1. How does Java decide which constructor should execute?
2. Why are constructors with different parameter lists allowed to have the same name?
3. What happens when no constructor matches the arguments used during object creation?
4. What changes when you explicitly add constructors to a class?

---

# Exercise 3: Static Application Information

**Task**

The restaurant platform needs information shared by all objects rather than information belonging to individual objects.

**Requirements**

* Create a `static` field in `AppConfig` representing the application name.
* Create another static field representing the delivery charge.
* Create a static field representing the number of orders created.
* Increase the order count whenever a new `Order` is created.
* Add static methods to access the application configuration.
* Add an instance method to display individual order information.

**Test it**

Create three orders.

Display:

* Application name.
* Delivery charge.
* Number of orders created.

Display each order's individual information.

**Experiment**

Modify the delivery charge.

Create another order.

Check whether the new order uses the modified value.

Then create multiple orders and observe the order counter.

**Why questions**

1. Why is the order count shared between all `Order` objects?
2. Why would making the order count non-static produce different behavior?
3. Why does changing a static value through one access point affect other objects?
4. Which data belongs to the class and which belongs to individual objects?

---

# Exercise 4: Singleton Application Configuration

**Task**

The application should have exactly one configuration object.

**Requirements**

* Make `AppConfig` a Singleton class.
* Prevent normal external object creation.
* Provide a way to obtain the single configuration instance.
* Store:

  * application name
  * delivery charge
  * maximum items per order
* Access the configuration from both `OrderService` and `RestaurantService`.

**Test it**

Obtain the configuration instance twice.

Compare the two references.

Change the delivery charge using one reference.

Read the delivery charge through the other reference.

**Experiment**

Attempt to create `AppConfig` directly using `new`.

Compile the program.

Then create another method that attempts to produce another configuration object and investigate whether your Singleton design actually prevents multiple instances.

**Why questions**

1. Why can't external classes directly create an `AppConfig` object?
2. Why do two calls for the configuration instance refer to the same object?
3. What role does the static member play in the Singleton design?
4. What would happen if the constructor were publicly accessible?

---

# Exercise 5: Inheritance and Method Overriding

**Task**

Different users should have different behavior while sharing common user information.

**Requirements**

* `User` must contain common user information.
* `Customer` must extend `User`.
* Create another subclass named `RestaurantOwner`.
* Add a method named `displayRole()` to `User`.
* Override `displayRole()` in `Customer`.
* Override `displayRole()` in `RestaurantOwner`.
* Give each implementation a different message.
* Create objects of both subclasses.

**Test it**

Call `displayRole()` on:

* a `Customer`
* a `RestaurantOwner`

**Experiment**

Remove `displayRole()` from one subclass.

Run the program again.

Then change the method signature in the subclass slightly and run the program again.

**Why questions**

1. Why does the subclass version execute when the object is a `Customer`?
2. What happens when the subclass does not override the method?
3. Why must the method signature match for overriding?
4. What happens when the method name or parameters are changed?

---

# Exercise 6: Runtime Polymorphism for Payments

**Task**

The application should support multiple payment methods without changing the order-processing code.

**Requirements**

* Create an abstract class or suitable common payment type named `Payment`.
* Give it a method named `pay()`.
* Create:

  * `CardPayment`
  * `UPIPayment`
  * `CashPayment`
* Each payment type must implement its own payment behavior.
* Store payment objects using the common `Payment` type.
* Create an `OrderService` method that accepts a `Payment` object.
* The order service must invoke `pay()` without checking which specific payment class it received.

**Test it**

Process the same order using:

* Card
* UPI
* Cash

Each payment implementation should produce different output.

**Experiment**

Create a `Payment` reference.

Assign a `CardPayment` object to it.

Call `pay()`.

Then assign a `UPIPayment` object to the same reference.

Call `pay()` again.

**Why questions**

1. Why can a `Payment` reference hold different payment implementations?
2. Why does `pay()` execute the subclass implementation?
3. Why doesn't `OrderService` need separate logic for every payment type?
4. What is determined by the reference type and what is determined by the actual object?

---

# Exercise 7: Method Overloading for Restaurant Search

**Task**

Allow the restaurant service to search using different criteria.

**Requirements**

Create overloaded methods named `searchRestaurant()`.

Create versions that accept:

* restaurant name
* restaurant name and city
* restaurant name, city, and maximum delivery time

Use different parameter lists for each version.

**Test it**

Search using:

* `Chennai Spice`
* `Chennai Spice`, `Chennai`
* `Chennai Spice`, `Chennai`, `40`

Print which search criteria were used.

**Experiment**

Create another `searchRestaurant()` method whose parameters have exactly the same types as an existing method but different parameter names.

Compile the program.

**Why questions**

1. Why are the different `searchRestaurant()` methods allowed?
2. Why don't parameter names create a separate overload?
3. How does Java determine which overloaded method should execute?
4. How is this different from method overriding?

---

# Exercise 8: Encapsulation of Order Data

**Task**

Prevent external classes from directly modifying important order information.

**Requirements**

* Make `Order` fields appropriately private.
* Do not allow external code to directly modify:

  * order ID
  * customer
  * restaurant
  * order items
  * total amount
* Provide methods that allow controlled operations.
* Create an `addItem()` method.
* Create a method for retrieving the current total.
* Create a method for displaying the order.
* Prevent an order from accepting more than the configured maximum number of items.

**Test it**

Create an order.

Add:

* Biryani
* Paneer Rice
* Lime Juice

Display the total.

Attempt to directly modify the total from `Main`.

Compile the program.

**Experiment**

Temporarily change the total field from `private` to `public`.

Modify it directly from `Main`.

Then restore encapsulation.

**Why questions**

1. Why should `totalAmount` not be directly accessible?
2. Why can `Order` control changes to its own state?
3. What advantage does `addItem()` provide over directly manipulating the collection?
4. What happens when you remove the access restriction?

---

# Exercise 9: Abstract Classes for Order Processing

**Task**

Different order types should share common behavior but have different delivery calculations.

**Requirements**

* Create an abstract class named `DeliveryOrder`.
* Give it:

  * order ID
  * customer
  * restaurant
* Add an abstract method named `calculateDeliveryFee()`.
* Create:

  * `StandardOrder`
  * `ExpressOrder`
* Implement `calculateDeliveryFee()` differently in each.
* Standard delivery should use the normal delivery charge.
* Express delivery should use a higher charge.
* Create a common method to display order information.

**Test it**

Create:

* 2 standard orders
* 2 express orders

Display the calculated delivery fee for each.

**Experiment**

Attempt to instantiate `DeliveryOrder` directly.

Compile the program.

**Why questions**

1. Why can't an abstract class be instantiated directly?
2. Why can subclasses of `DeliveryOrder` be instantiated?
3. What common behavior belongs in the abstract class?
4. Why does each subclass calculate its delivery fee differently?

---

# Exercise 10: Interfaces for Application Capabilities

**Task**

Some classes should support capabilities that are not necessarily related through inheritance.

**Requirements**

Create these interfaces:

* `Trackable`
* `Discountable`

`Trackable` must define behavior for tracking an order.

`Discountable` must define behavior for calculating a discount.

Make `Order` implement `Trackable`.

Make `FoodItem` or another suitable class implement `Discountable`.

Create another class that implements both interfaces.

**Test it**

Use the interface references to:

* Track an order.
* Calculate a discount.

**Experiment**

Create a class that implements `Trackable` but intentionally does not implement the required behavior.

Compile the program.

**Why questions**

1. Why can a class implement an interface without inheriting from a parent class?
2. What happens when a class does not implement all required interface methods?
3. Why can one class implement multiple interfaces?
4. How is an interface relationship different from normal class inheritance?

---

# Exercise 11: Access Control Across Packages

**Task**

Make the package structure meaningful by testing Java access control between packages.

**Requirements**

Use the package structure:

```text
models
services
payments
app
```

Create members with different access levels inside `Order`.

Include:

* one private member
* one protected member
* one public member
* one package-private member

Create an `OrderService` in another package.

Attempt to access each member directly.

**Test it**

Compile after attempting each access separately.

Then provide controlled public methods for the information that `OrderService` legitimately needs.

**Experiment**

Create a subclass of `Order` in the `services` package.

Test access to the protected member.

Then create an unrelated class in the same package as `Order`.

Test its access to the package-private member.

**Why questions**

1. Why can the public member be accessed from another package?
2. Why can't the private member be accessed directly?
3. Why does inheritance affect protected access?
4. Why does package location affect package-private access?

---

# Exercise 12: `final` Rules

**Task**

The application contains information that should not be changed or overridden.

**Requirements**

Create:

* a final delivery policy value
* a final method in an appropriate class
* a final class for a utility/configuration component where inheritance does not make sense

Use `final` appropriately.

**Test it**

Attempt to:

* change the final value
* override the final method
* extend the final class

Compile after each change.

**Experiment**

Remove `final` one at a time.

Try the corresponding operation again.

**Why questions**

1. What does `final` prevent in each of these three situations?
2. Why would a configuration/utility class be a candidate for being final?
3. Why can a final method not be overridden?
4. What changes when the `final` keyword is removed?

---

# Exercise 13: Object Class and `toString()`

**Task**

Make your domain objects useful when printed.

**Requirements**

Override `toString()` in:

* `Customer`
* `Restaurant`
* `FoodItem`
* `Order`

The returned representation should contain meaningful information about each object.

Print the objects directly instead of manually printing every field.

**Test it**

Print:

* a customer
* a restaurant
* three food items
* an order

**Experiment**

Remove `toString()` from `FoodItem`.

Print the object again.

Then restore it.

**Why questions**

1. Why can every one of these classes use `toString()`?
2. What changes when you provide your own implementation?
3. Why does printing an object result in a string representation?
4. What behavior did the class inherit before you overrode `toString()`?

---

# Exercise 14: `equals()` and Object Identity

**Task**

Two restaurants may contain identical information but still represent different objects.

Investigate and then define what equality should mean for your application.

**Requirements**

* Create two `Restaurant` objects:

  * ID `101`
  * Name `Chennai Spice`
  * Location `Chennai`
* Compare them using `==`.
* Compare them using `equals()`.
* Create a third reference pointing to the first object.
* Compare the first and third references.

Then override `equals()` so that restaurants with the same restaurant ID are considered equal.

**Test it**

Compare:

* restaurant 1 vs restaurant 2
* restaurant 1 vs restaurant 3

Then change restaurant 2's ID and repeat the comparisons.

**Experiment**

Create two restaurants with the same ID but different names.

Run the equality test.

**Why questions**

1. What does `==` compare for objects?
2. What behavior does `equals()` have before you override it?
3. Why might restaurant ID be a better definition of equality than restaurant name?
4. What happens when two objects have the same ID but different names?

---

# Exercise 15: Object Cloning

**Task**

The restaurant system should be able to create a copy of an existing food item.

**Requirements**

* Make `FoodItem` support object cloning.
* Create an original food item.
* Create a clone of it.
* Print both objects.
* Modify the clone's price.
* Display both objects again.

**Test it**

Original:

* `Chicken Biryani`
* ₹220

Clone:

* Same initial information

Change only the clone's price to ₹250.

**Experiment**

Change another mutable field in the clone.

Observe whether the original object changes.

**Why questions**

1. Why are the original and cloned objects separate objects?
2. What happens when you modify the clone?
3. Why would cloning become more complicated when an object contains references to other mutable objects?
4. How is cloning different from simply assigning one object reference to another?

---

# Exercise 16: Generics for a Reusable Repository

**Task**

The application has several types of objects that need to be stored and retrieved.

Create a generic class named `Repository<T>`.

**Requirements**

`Repository<T>` must support:

* adding an object
* retrieving an object
* retrieving all objects
* checking whether it contains objects
* returning its current size

Create repositories for:

* `Customer`
* `Restaurant`
* `FoodItem`
* `Order`

Do not create separate repository classes for every type.

**Test it**

Create:

* 3 customers
* 2 restaurants
* 5 food items
* 3 orders

Store each group in the appropriate repository.

Retrieve and display the objects.

**Experiment**

Attempt to add a `Restaurant` object to a `Repository<Customer>`.

Compile the program.

**Why questions**

1. Why can the same `Repository` class work with different object types?
2. Why does `Repository<Customer>` reject a `Restaurant`?
3. What problem would occur if the repository accepted arbitrary object types?
4. What does the generic type parameter control?

---

# Exercise 17: Custom Generic Utility

**Task**

Create a generic utility class named `Pair<K, V>`.

Use it to represent two related values.

**Requirements**

Create pairs for:

* restaurant ID and restaurant name
* customer ID and customer name
* order ID and order status

The class must provide access to both values.

Create objects using different types for `K` and `V`.

**Test it**

Create at least three different `Pair` objects using different type combinations.

Display their values.

**Experiment**

Attempt to assign a `Pair<Integer, String>` to a variable expecting an incompatible generic type.

Compile the program.

**Why questions**

1. Why can the same class represent different combinations of types?
2. Why does Java reject incompatible generic assignments?
3. What advantage does this provide over using `Object` everywhere?
4. What information does the generic declaration give the compiler?

---

# Exercise 18: Exceptions in Order Processing

**Task**

Invalid orders should not crash the entire application without being handled.

**Requirements**

Create:

* `InvalidOrderException`
* `PaymentException`

Make them appropriate exception types.

`OrderService` must detect invalid situations such as:

* an order containing no food items
* an order exceeding the maximum item count
* attempting to process an already completed order
* an invalid payment amount

Throw the appropriate exception.

Handle the exceptions in `Main`.

The application should display an understandable error message and continue running.

**Test it**

Trigger each invalid condition separately.

Run the application after each test.

**Experiment**

Allow the exception to propagate without handling it in `Main`.

Run the application.

Observe what happens.

Then restore the handling.

**Why questions**

1. Why does an exception interrupt the normal flow of the program?
2. Why is a custom exception useful here?
3. What happens when the exception is not handled?
4. Why should invalid order conditions be represented as exceptional situations?

---

# Exercise 19: Collections Framework for Orders

**Task**

The restaurant needs to manage a changing number of orders.

Do not use a fixed-size array for the main order storage.

**Requirements**

Create an order management component using a suitable Java collection.

It must support:

* adding orders
* removing an order
* finding an order by ID
* displaying all orders
* checking the number of orders

Store at least 5 orders.

Use another collection for a restaurant's menu.

**Test it**

Perform these operations:

1. Add 5 orders.
2. Display all orders.
3. Find order `1003`.
4. Remove order `1002`.
5. Display the remaining orders.
6. Add another order.
7. Display the new count.

**Experiment**

Attempt to retrieve an order using an invalid index if your chosen collection supports indexed access.

Handle the resulting problem appropriately.

**Why questions**

1. Why is a collection more appropriate than a fixed-size array for changing order data?
2. What happens when you remove an element?
3. Why does the collection automatically manage its changing size?
4. What behavior depends on the particular collection implementation you selected?

---

# Exercise 20: Vector-Based Order History

**Task**

Create a separate order history using Java's `Vector`.

**Requirements**

* Create a `Vector<Order>`.
* Add completed orders to it.
* Display the history.
* Retrieve an order by position.
* Remove an order from the history.
* Display the final history size.

**Test it**

Add 5 completed orders.

Remove the third order.

Display the remaining history.

**Experiment**

Attempt to access an index outside the Vector's valid range.

Run the program and observe the exception.

**Why questions**

1. What happens when the Vector grows beyond its initial capacity?
2. Why does accessing an invalid position produce an exception?
3. How does Vector differ from the fixed-size array you used earlier?
4. Why might a collection be preferable when the number of objects changes during program execution?

---

# Exercise 21: Lambda Expressions for Restaurant Filtering

**Task**

The restaurant service needs flexible filtering without creating a separate method for every possible condition.

**Requirements**

Create a collection containing at least 6 restaurants.

Each restaurant should have:

* name
* location
* rating
* average delivery time

Use lambda expressions to filter restaurants based on conditions such as:

* rating greater than or equal to `4.0`
* delivery time less than or equal to `30`
* restaurants located in `Chennai`

Use the filtering behavior while processing the collection.

**Test it**

Create at least these restaurants:

* Chennai Spice, Chennai, 4.5, 25 minutes
* Madras Meals, Chennai, 3.8, 35 minutes
* Coastal Kitchen, Chennai, 4.2, 30 minutes
* Bangalore Bites, Bangalore, 4.6, 25 minutes
* Hyderabad House, Hyderabad, 4.1, 40 minutes
* Street Feast, Chennai, 3.9, 20 minutes

Run at least three different filters.

**Experiment**

Change the filtering condition without creating another named method.

**Why questions**

1. What does the lambda expression allow you to express?
2. Why can the filtering condition change without changing the restaurant class?
3. What object or behavior is being supplied to the filtering operation?
4. What advantage does this provide over creating a separate method for every filter?

---

# Exercise 22: Enums for Application State

**Task**

The application should not represent order and payment states using arbitrary strings.

**Requirements**

Create:

```text
OrderStatus
```

with states representing the order lifecycle.

For example, the lifecycle should include states for:

* newly created
* confirmed
* preparing
* out for delivery
* delivered
* cancelled

Create:

```text
PaymentStatus
```

with appropriate payment states.

Use these enums inside `Order`.

Do not use strings such as `"delivered"` or `"cancelled"` to represent the state.

**Test it**

Create an order.

Move it through the lifecycle:

```text
created
→ confirmed
→ preparing
→ out for delivery
→ delivered
```

Display the status after each transition.

**Experiment**

Attempt to assign an arbitrary string to the order's status.

Compile the program.

**Why questions**

1. Why is an enum safer than storing status as a string?
2. What happens when code attempts to assign an invalid status?
3. Why does the compiler know which values are valid?
4. What happens if you later add another value to the enum?

---

# Exercise 23: Annotations

**Task**

Use annotations in a small, meaningful part of the application.

**Requirements**

* Override at least one inherited method and mark it appropriately with the relevant Java annotation.
* Create one custom annotation for identifying a class as part of the application's domain model.
* Apply the custom annotation to at least two classes.
* Inspect the annotation from the program where appropriate.

**Test it**

Apply the custom annotation to:

* `Restaurant`
* `FoodItem`

Run the program and verify that the annotated classes can be identified.

**Experiment**

Remove the annotation from one class.

Run the inspection again.

**Why questions**

1. What information does the annotation provide?
2. Why does an annotation not normally represent the main business behavior of the class?
3. What does the override-related annotation help the compiler detect?
4. What changed when you removed the custom annotation?

---

# Exercise 24: Combine Everything Into the Console Application

**Task**

Now connect all the pieces into one usable application.

The application should behave like a small food delivery platform operated entirely from the console.

**Requirements**

When the application starts, display a menu similar to:

```text
===== FOOD DELIVERY SYSTEM =====

1. View Restaurants
2. View Restaurant Menu
3. Create Customer
4. Create Order
5. Add Food Item to Order
6. View Order
7. Make Payment
8. View Order History
9. Track Order
10. Exit
```

You may design the exact menu interaction yourself.

The application must support:

* Creating customers.
* Creating restaurants.
* Maintaining restaurant menus.
* Viewing restaurants.
* Viewing food items.
* Creating orders.
* Adding items to orders.
* Calculating the order total.
* Calculating delivery charges.
* Choosing a payment method.
* Processing payments through polymorphism.
* Updating order status.
* Viewing order history.
* Searching/filtering restaurants.
* Handling invalid operations with exceptions.
* Using enums for state.
* Using collections for dynamic data.
* Using generics somewhere in the application.
* Using at least one lambda expression.
* Using inheritance.
* Using method overloading.
* Using method overriding.
* Using encapsulation.
* Using abstraction.
* Using interfaces.
* Using static members.
* Using a Singleton.
* Using `final`.
* Using packages.
* Using access modifiers.
* Overriding `toString()`.
* Overriding `equals()`.
* Demonstrating object cloning.
* Using annotations.

---

# Required Package Responsibilities

Keep the packages meaningful.

### `models`

Contains the application's data/domain objects.

Examples:

* `User`
* `Customer`
* `Restaurant`
* `FoodItem`
* `Order`
* `Address`

### `payments`

Contains payment-related behavior.

Examples:

* `Payment`
* `CardPayment`
* `UPIPayment`
* `CashPayment`

### `services`

Contains operations performed on the domain objects.

Examples:

* restaurant searching
* order creation
* order processing
* payment processing

### `exceptions`

Contains custom exceptions.

### `utils`

Contains shared utility/configuration functionality.

### `enums`

Contains application states.

### `app`

Contains `Main.java` and the console application's entry point.

---

# Final Testing Scenario

After the application is complete, test this exact scenario.

**Customers**

Create:

* Arun
* Priya

**Restaurants**

Create:

* Chennai Spice
* Coastal Kitchen

**Menu**

Chennai Spice:

* Chicken Biryani - ₹220
* Paneer Rice - ₹180
* Fresh Lime - ₹60

Coastal Kitchen:

* Fish Meals - ₹250
* Chicken Noodles - ₹200
* Lemon Soda - ₹50

**Order 1**

Arun orders from Chennai Spice:

* Chicken Biryani
* Fresh Lime

Use UPI.

Move the order through:

```text
Created
→ Confirmed
→ Preparing
→ Out for Delivery
→ Delivered
```

**Order 2**

Priya orders from Coastal Kitchen:

* Fish Meals
* Lemon Soda

Use card payment.

Cancel the order before delivery.

**Order 3**

Arun creates another order.

Attempt to add more items than the configured maximum.

The application must handle the invalid operation without terminating.

---

# Final Experiments

Once the complete application works, deliberately break parts of it.

Perform these experiments **one at a time**.

### Experiment 1: Encapsulation

Attempt to modify an `Order` field directly from `Main`.

Compile.

### Experiment 2: Access Control

Attempt to access a private member from another package.

Compile.

### Experiment 3: Inheritance

Remove an overridden method from a subclass.

Run the program.

### Experiment 4: Polymorphism

Change the actual payment implementation while keeping the common payment reference.

Run the program.

### Experiment 5: Abstract Class

Attempt to instantiate the abstract payment/order type.

Compile.

### Experiment 6: Interface

Remove the implementation of one required interface method.

Compile.

### Experiment 7: Generics

Attempt to put an object of the wrong type into a typed repository.

Compile.

### Experiment 8: Enum

Attempt to assign an arbitrary string to an enum field.

Compile.

### Experiment 9: Singleton

Attempt to create the configuration object using `new`.

Compile.

### Experiment 10: Final

Attempt to change a final value.

Compile.

### Experiment 11: `equals()`

Remove your `equals()` implementation and compare two logically identical objects.

Run the program.

### Experiment 12: `toString()`

Remove your `toString()` implementation and print an object.

Run the program.

### Experiment 13: Cloning

Clone a `FoodItem`, modify the clone, and compare it with the original.

### Experiment 14: Exception Handling

Allow an invalid order exception to propagate without handling it.

Run the program.

### Experiment 15: Lambda

Change the restaurant filtering condition without creating another filtering method.

Run the program.

---

# Final Why Questions

1. Why does `Customer` inherit common behavior from `User` while payment implementations use a common payment abstraction?
2. Why is `Order` responsible for protecting its own internal state instead of allowing `Main` to modify everything directly?
3. Why can the same `Payment` reference represent card, UPI, and cash payments?
4. Why are interfaces useful for capabilities such as tracking and discounting?
5. Why is an abstract class useful when several classes share some implementation but must provide different behavior?
6. Why are enums preferable to arbitrary strings for order state?
7. Why does a generic `Repository<T>` provide stronger type safety than a repository accepting `Object`?
8. Why does the Singleton configuration remain shared across different services?
9. Why does overriding `toString()` change what you see when printing an object?
10. Why can two objects containing the same logical information require a custom `equals()` implementation?
11. Why does cloning produce a separate object rather than another reference to the same object?
12. Why do access modifiers behave differently when classes are moved between packages?
13. Why can the collection grow and shrink while an array has a fixed size?
14. Why can a lambda change filtering behavior without modifying the restaurant model?
15. Looking at the completed application, which classes represent **data**, which represent **behavior**, and which represent **application infrastructure**?
16. Which parts of your application would become difficult to maintain if everything were placed inside `Main.java`?
17. Why does the package structure make the console application easier to organize even though it is not a Spring application?
18. Which parts of the application demonstrate **inheritance**, **composition**, **polymorphism**, **encapsulation**, and **abstraction**?
