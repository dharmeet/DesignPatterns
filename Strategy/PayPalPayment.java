package DesignPatterns.Strategy;

/**
 * Concrete strategy for PayPal payments
 */
public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;
    
    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    @Override
    public boolean pay(double amount) {
        System.out.println("Paying $" + amount + " using PayPal");
        System.out.println("PayPal Account: " + email);
        System.out.println("Redirecting to PayPal for authentication...");
        System.out.println("Processing PayPal transaction...");
        // In a real implementation, we'd use the PayPal API here
        return true; // Simulate successful payment
    }
    
    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
}