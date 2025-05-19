package DesignPatterns.Decorator;

// Concrete Decorator
public class WhippedCreamDecorator extends BeverageDecorator {
    public WhippedCreamDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", with Whipped Cream";
    }
    
    @Override
    public double getCost() {
        return beverage.getCost() + 0.7; // Whipped cream costs extra $0.70
    }
}
