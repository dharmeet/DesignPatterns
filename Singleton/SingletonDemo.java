package DesignPatterns.Singleton;

/**
 * SingletonDemo demonstrates the usage of different Singleton patterns.
 */
public class SingletonDemo {
    public static void main(String[] args) {
        // Double-check locking singleton
        DoubleCheckLockingSingleton instance1 = DoubleCheckLockingSingleton.getInstance();
        instance1.doSomething();
        
        // Bill Pugh singleton
        BillPughSingleton instance2 = BillPughSingleton.getInstance();
        instance2.doSomething();
        
        // Enum singleton
        EnumSingleton instance3 = EnumSingleton.INSTANCE;
        instance3.setConfig("Custom configuration");
        instance3.doSomething();
        
        // Verify they are singletons
        System.out.println("Is the same instance? " + 
            (DoubleCheckLockingSingleton.getInstance() == instance1));
        System.out.println("Is the same instance? " + 
            (BillPughSingleton.getInstance() == instance2));
        System.out.println("Is the same instance? " + 
            (EnumSingleton.INSTANCE == instance3));
    }
}