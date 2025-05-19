package DesignPatterns.Strategy;

/**
 * Concrete strategy for Bitcoin payments
 */
public class BitcoinPayment implements PaymentStrategy {
    private String walletAddress;
    
    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }
    
    @Override
    public boolean pay(double amount) {
        System.out.println("Paying $" + amount + " equivalent in Bitcoin");
        System.out.println("Bitcoin Wallet: " + walletAddress);
        System.out.println("Generating Bitcoin transaction...");
        System.out.println("Waiting for blockchain confirmation...");
        // In a real implementation, we'd use a Bitcoin payment processor
        return true; // Simulate successful payment
    }
    
    @Override
    public String getPaymentMethod() {
        return "Bitcoin";
    }
}