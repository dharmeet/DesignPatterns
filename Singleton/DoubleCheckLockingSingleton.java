package DesignPatterns.Singleton;

public class DoubleCheckLockingSingleton {
    // The volatile keyword ensures that multiple threads handle the instance variable correctly
    private static volatile DoubleCheckLockingSingleton instance;
    
    // Private constructor prevents instantiation from other classes
    private DoubleCheckLockingSingleton() {
        // Prevent instantiation via reflection
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the instance");
        }
    }
    
    public static DoubleCheckLockingSingleton getInstance() {
        // First check (no synchronization needed)
        if (instance == null) {
            // Synchronize only when instance is null
            synchronized (DoubleCheckLockingSingleton.class) {
                // Double check to ensure instance is still null inside synchronized block
                if (instance == null) {
                    instance = new DoubleCheckLockingSingleton();
                }
            }
        }
        return instance;
    }
    
    // Business methods
    public void doSomething() {
        System.out.println("Singleton is doing something");
    }
}