package DesignPatterns.Facade;

/**
 * One of the complex subsystem components
 */
public class Television {
    private String description;
    private int channel;
    
    public Television(String description) {
        this.description = description;
        this.channel = 1;
    }
    
    public void turnOn() {
        System.out.println(description + " TV turning on");
    }
    
    public void turnOff() {
        System.out.println(description + " TV turning off");
    }
    
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println(description + " TV setting channel to " + channel);
    }
}