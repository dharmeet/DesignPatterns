package DesignPatterns.AbstractFactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        // Create factories
        GUIFactory windowsFactory = new WindowsFactory();
        GUIFactory macFactory = new MacFactory();
        
        // Create application with Windows UI
        System.out.println("Creating Windows UI:");
        Application windowsApp = new Application(windowsFactory);
        windowsApp.createUI();
        windowsApp.simulateUserInteraction();
        
        // Create application with macOS UI
        System.out.println("\nCreating macOS UI:");
        Application macApp = new Application(macFactory);
        macApp.createUI();
        macApp.simulateUserInteraction();
    }
}