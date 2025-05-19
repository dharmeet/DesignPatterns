package DesignPatterns.Facade;

/**
 * Another complex subsystem component
 */
public class Projector {
    private String description;
    private Television input;
    
    public Projector(String description) {
        this.description = description;
    }
    
    public void turnOn() {
        System.out.println(description + " projector turning on");
    }
    
    public void turnOff() {
        System.out.println(description + " projector turning off");
    }
    
    public void setInput(Television tv) {
        this.input = tv;
        System.out.println(description + " projector setting input to TV");
    }
}