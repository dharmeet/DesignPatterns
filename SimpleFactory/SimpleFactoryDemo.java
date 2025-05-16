package DesignPatterns.SimpleFactory;

public class SimpleFactoryDemo {
    public static void main(String[] args) {
        // Create the factory
        ShapeFactory factory = new ShapeFactory();
        
        // Create shapes using the factory
        Shape circle = factory.createShape("CIRCLE");
        Shape rectangle = factory.createShape("RECTANGLE");
        
        // Use the shapes
        circle.draw();
        rectangle.draw();
    }
}