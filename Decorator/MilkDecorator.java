package DesignPatterns.Decorator;

// Concrete Decorator
public class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", with Milk";
    }
    
    @Override
    public double getCost() {
        return beverage.getCost() + 0.5; // Milk costs extra $0.50
    }
}
