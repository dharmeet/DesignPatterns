package DesignPatterns.SimpleFactory;

// Notice that createShape() violates the Open/Closed Principle.
// The Simple Factory is not a design pattern but a programming idiom, and to correct the 
// violation of the Open/Closed Principle, we can use the Factory Method pattern.
public class ShapeFactory {
    public Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null; // Return null if no matching shape type is found
    }
}
