package DesignPatterns.FactoryMethod;

// Concrete creator
public class RoadLogistics extends LogisticsCompany {
    @Override
    protected Transport createTransport() {
        return new Truck();
    }
}