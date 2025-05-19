package DesignPatterns.Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Context that uses a payment strategy
 */
public class ShoppingCart {
    private List<Item> items;
    
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public void removeItem(Item item) {
        items.remove(item);
    }
    
    public double calculateTotal() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
    
    /**
     * Method that uses the payment strategy to process payment
     */
    public boolean checkout(PaymentStrategy paymentStrategy) {
        double total = calculateTotal();
        
        System.out.println("\n=== Processing Order ===");
        System.out.println("Shopping Cart Contents:");
        for (Item item : items) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Total: $" + total);
        
        System.out.println("\nPayment Method: " + paymentStrategy.getPaymentMethod());
        
        // Delegate payment processing to the strategy
        boolean success = paymentStrategy.pay(total);
        
        if (success) {
            System.out.println("Payment successful! Order completed.");
            items.clear(); // Clear cart after successful checkout
        } else {
            System.out.println("Payment failed! Please try again.");
        }
        
        return success;
    }
}