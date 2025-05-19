package DesignPatterns.Facade;

/**
 * Another complex subsystem component
 */
public class SoundSystem {
    private String description;
    private int volume;
    private String mode;
    
    public SoundSystem(String description) {
        this.description = description;
        this.volume = 0;
        this.mode = "Stereo";
    }
    
    public void turnOn() {
        System.out.println(description + " sound system turning on");
    }
    
    public void turnOff() {
        System.out.println(description + " sound system turning off");
    }
    
    public void setVolume(int level) {
        this.volume = level;
        System.out.println(description + " sound system setting volume to " + level);
    }
    
    public void setStereo() {
        this.mode = "Stereo";
        System.out.println(description + " sound system setting mode to Stereo");
    }
    
    public void setSurroundSound() {
        this.mode = "Surround Sound";
        System.out.println(description + " sound system setting mode to Surround Sound");
    }
}