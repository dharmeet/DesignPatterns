package DesignPatterns.AbstractFactory;

// Concrete product A2
public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a macOS-style button");
    }
    
    @Override
    public void onClick() {
        System.out.println("macOS button clicked");
    }
}