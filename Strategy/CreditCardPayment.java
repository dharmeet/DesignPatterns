package DesignPatterns.Strategy;

/**
 * Concrete strategy for credit card payments
 */
public class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String expiryDate;
    
    public CreditCardPayment(String name, String cardNumber, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
    
    @Override
    public boolean pay(double amount) {
        System.out.println("Paying $" + amount + " using Credit Card");
        System.out.println("Card holder: " + name);
        System.out.println("Card Number: " + maskCardNumber(cardNumber));
        System.out.println("Verifying card details and processing transaction...");
        // In a real implementation, we'd call a payment gateway service here
        return true; // Simulate successful payment
    }
    
    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
    
    private String maskCardNumber(String cardNumber) {
        // Show only the last 4 digits of the card number
        return "XXXX-XXXX-XXXX-" + cardNumber.substring(cardNumber.length() - 4);
    }
}