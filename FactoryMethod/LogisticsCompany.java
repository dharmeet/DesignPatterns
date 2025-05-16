package DesignPatterns.FactoryMethod;

// Abstract creator
public abstract class LogisticsCompany {
    // Factory method this ensures extensibility and does not violate the Open/Closed Principle
    // by allowing subclasses to provide specific implementations.
    protected abstract Transport createTransport();
    
    // Business logic using the factory method
    public void planDelivery() {
        // Create transport using factory method
        Transport transport = createTransport();
        
        System.out.println("Planning logistics...");
        transport.deliver();
        System.out.println("Delivery completed!");
    }
}