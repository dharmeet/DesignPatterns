package DesignPatterns.Decorator;

// Another Concrete Component
public class Espresso implements Beverage {
    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double getCost() {
        return 3.0; // Base price
    }
}