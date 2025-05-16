package DesignPatterns.FactoryMethod;

// Concrete creator
public class SeaLogistics extends LogisticsCompany {
    @Override
    protected Transport createTransport() {
        return new Ship();
    }
}