package DesignPatterns.Adapter;

// Original service PhonePe was using
public class YesBankUpiProcessor implements UpiPaymentProcessor {
    
    @Override
    public boolean processPayment(String sourceAccountId, String targetAccountId, double amount) {
        System.out.println("YesBank: Processing payment of ₹" + amount + 
                " from " + sourceAccountId + " to " + targetAccountId);
        // YesBank specific payment logic
        return true;
    }
    
    @Override
    public boolean verifyAccount(String accountId) {
        System.out.println("YesBank: Verifying account " + accountId);
        // YesBank specific verification logic
        return true;
    }
    
    @Override
    public double getBalance(String accountId) {
        System.out.println("YesBank: Fetching balance for account " + accountId);
        // YesBank specific balance retrieval logic
        return 5000.00;
    }
}