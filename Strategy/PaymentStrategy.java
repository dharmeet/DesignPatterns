package DesignPatterns.Strategy;

/**
 * The Strategy interface declares operations common to all supported payment methods
 */
public interface PaymentStrategy {
    boolean pay(double amount);
    String getPaymentMethod();
}