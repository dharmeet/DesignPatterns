package DesignPatterns.FactoryMethod;

public class FactoryMethodDemo {
    public static void main(String[] args) {
        // Create different logistics companies
        LogisticsCompany roadLogistics = new RoadLogistics();
        LogisticsCompany seaLogistics = new SeaLogistics();
        
        // Plan deliveries using different transport methods
        System.out.println("Road delivery:");
        // Notice that the roadLogistics planDelivery will call createTransport which will
        // return a Truck object.
        roadLogistics.planDelivery();
        
        System.out.println("\nSea delivery:");
        // Notice that the seaLogistics planDelivery will call createTransport which will
        // return a Ship object.
        seaLogistics.planDelivery();
    }
}