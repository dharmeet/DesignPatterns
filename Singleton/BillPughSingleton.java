package DesignPatterns.Singleton;

public class BillPughSingleton {
    
    // Private constructor prevents instantiation from other classes
    private BillPughSingleton() {
        // Prevent instantiation via reflection
        if (SingletonHelper.INSTANCE != null) {
            throw new RuntimeException("Use getInstance() method to get the instance");
        }
    }
    
    // Static inner helper class - not loaded until getInstance() is called
    private static class SingletonHelper {
        // Instance created when the helper class is loaded
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    // Business methods
    public void doSomething() {
        System.out.println("Bill Pugh Singleton is doing something");
    }
}