package DesignPatterns.Decorator;

// Concrete Decorator
public class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", with Sugar";
    }
    
    @Override
    public double getCost() {
        return beverage.getCost() + 0.2; // Sugar costs extra $0.20
    }
}
