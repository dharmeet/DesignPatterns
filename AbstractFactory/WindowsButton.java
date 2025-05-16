package DesignPatterns.AbstractFactory;

// Concrete product A1
public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Windows-style button");
    }
    
    @Override
    public void onClick() {
        System.out.println("Windows button clicked");
    }
}