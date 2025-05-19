package DesignPatterns.Decorator;

// Concrete Decorator
public class CinnamonDecorator extends BeverageDecorator {
    public CinnamonDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", with Cinnamon";
    }
    
    @Override
    public double getCost() {
        return beverage.getCost() + 0.3; // Cinnamon costs extra $0.30
    }
}
