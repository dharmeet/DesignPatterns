package DesignPatterns.Facade;

/**
 * Another complex subsystem component
 */
public class Lights {
    private String description;
    private int brightness;
    
    public Lights(String description) {
        this.description = description;
        this.brightness = 100; // Full brightness by default
    }
    
    public void dim(int level) {
        this.brightness = level;
        System.out.println(description + " lights dimming to " + level + "%");
    }
    
    public void brighten(int level) {
        this.brightness = level;
        System.out.println(description + " lights brightening to " + level + "%");
    }
}