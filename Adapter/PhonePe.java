package DesignPatterns.Adapter;

// Client code - PhonePe app using the payment processor
public class PhonePe {
    // Having a dependency on the UpiPaymentProcessor interface saved 
    // us from changing the PhonePe class when we switched from
    // YesBank to ICICI Bank. We can now switch between different paymentProcessors.
    private UpiPaymentProcessor paymentProcessor;
    
    public PhonePe(UpiPaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }
    
    // Method to switch to a different payment processor
    public void switchPaymentProcessor(UpiPaymentProcessor newProcessor) {
        System.out.println("Switching payment processor...");
        this.paymentProcessor = newProcessor;
    }
    
    public void makePayment(String from, String to, double amount) {
        // Verify accounts
        if (!paymentProcessor.verifyAccount(from)) {
            System.out.println("Source account verification failed!");
            return;
        }
        
        if (!paymentProcessor.verifyAccount(to)) {
            System.out.println("Target account verification failed!");
            return;
        }
        
        // Check balance
        double balance = paymentProcessor.getBalance(from);
        if (balance < amount) {
            System.out.println("Insufficient balance!");
            return;
        }
        
        // Process the payment
        boolean success = paymentProcessor.processPayment(from, to, amount);
        if (success) {
            System.out.println("Payment successful!");
        } else {
            System.out.println("Payment failed!");
        }
    }
}