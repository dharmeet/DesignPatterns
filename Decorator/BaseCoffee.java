package DesignPatterns.Decorator;

// Concrete Component
public class BaseCoffee implements Beverage {
    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double getCost() {
        return 2.0; // Base price
    }
}