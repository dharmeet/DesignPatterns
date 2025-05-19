package DesignPatterns.Strategy;

import java.util.Scanner;

/**
 * Main demonstration of the Strategy pattern
 */
public class StrategyDemo {
    public static void main(String[] args) {
        // Create a shopping cart and add items
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Laptop", 999.99));
        cart.addItem(new Item("Headphones", 149.99));
        cart.addItem(new Item("Mouse", 29.99));
        
        System.out.println("===== E-Commerce Payment System Demo =====");
        System.out.println("Your shopping cart contains items totaling: $" + cart.calculateTotal());
        
        // Demo with manual strategy selection
        simulateManualCheckout(cart);
        
        // Reset cart for interactive demo
        cart = new ShoppingCart();
        cart.addItem(new Item("Smartphone", 799.99));
        cart.addItem(new Item("Wireless Charger", 49.99));
        
        // Demo with interactive strategy selection
        simulateInteractiveCheckout(cart);
        
        System.out.println("\n===== Benefits of Strategy Pattern =====");
        System.out.println("1. Algorithms (payment methods) are encapsulated and interchangeable");
        System.out.println("2. Client code (shopping cart) is decoupled from specific algorithms");
        System.out.println("3. New payment methods can be added without changing existing code");
        System.out.println("4. Runtime selection of appropriate algorithm based on context");
    }
    
    /**
     * Demonstrates manually switching between different payment strategies
     */
    private static void simulateManualCheckout(ShoppingCart cart) {
        System.out.println("\n--- Demo: Using Different Payment Strategies ---");
        
        // Strategy 1: Credit Card Payment
        System.out.println("\n[Customer decides to pay with Credit Card]");
        PaymentStrategy creditCardStrategy = new CreditCardPayment(
            "John Doe", 
            "1234567890123456", 
            "123", 
            "12/25"
        );
        cart.checkout(creditCardStrategy);
        
        // Create a new cart as the previous one was cleared after checkout
        ShoppingCart newCart = new ShoppingCart();
        newCart.addItem(new Item("Tablet", 349.99));
        newCart.addItem(new Item("Case", 39.99));
        
        // Strategy 2: PayPal Payment
        System.out.println("\n[Another customer decides to pay with PayPal]");
        PaymentStrategy payPalStrategy = new PayPalPayment(
            "jane.doe@example.com", 
            "secure_password"
        );
        newCart.checkout(payPalStrategy);
    }
    
    /**
     * Demonstrates interactive selection of payment strategies
     */
    private static void simulateInteractiveCheckout(ShoppingCart cart) {
        System.out.println("\n--- Interactive Demo: Choose Your Payment Strategy ---");
        System.out.println("Your shopping cart contains items totaling: $" + cart.calculateTotal());
        
        Scanner scanner = new Scanner(System.in);
        PaymentStrategy selectedStrategy = null;
        
        System.out.println("\nSelect a payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Bitcoin");
        System.out.print("Enter your choice (1-3): ");
        
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    selectedStrategy = new CreditCardPayment(
                        "Jane Smith", 
                        "4111111111111111", 
                        "789", 
                        "05/26"
                    );
                    break;
                case 2:
                    selectedStrategy = new PayPalPayment(
                        "jane.smith@example.com", 
                        "paypal_password"
                    );
                    break;
                case 3:
                    selectedStrategy = new BitcoinPayment(
                        "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa"
                    );
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to Credit Card.");
                    selectedStrategy = new CreditCardPayment(
                        "Jane Smith", 
                        "4111111111111111", 
                        "789", 
                        "05/26"
                    );
            }
            
            // Process checkout with the selected strategy
            cart.checkout(selectedStrategy);
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        } finally {
            // Note: In a real application, you might not want to close System.in
            // scanner.close();
        }
    }
}