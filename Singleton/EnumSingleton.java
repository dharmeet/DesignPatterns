package DesignPatterns.Singleton;

public enum EnumSingleton {
    INSTANCE;
    
    // You can add state
    private String config;
    
    // Initialize in constructor
    EnumSingleton() {
        this.config = "Default configuration";
    }
    
    // Business methods
    public void doSomething() {
        System.out.println("Enum Singleton is doing something with config: " + config);
    }
    
    public String getConfig() {
        return config;
    }
    
    public void setConfig(String config) {
        this.config = config;
    }
}