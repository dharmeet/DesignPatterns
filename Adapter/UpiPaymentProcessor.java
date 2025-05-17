package DesignPatterns.Adapter;

// Target interface - what PhonePe expects to work with
public interface UpiPaymentProcessor {
    boolean processPayment(String sourceAccountId, String targetAccountId, double amount);
    boolean verifyAccount(String accountId);
    double getBalance(String accountId);
}