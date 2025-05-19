package DesignPatterns.Facade;

/**
 * Another complex subsystem component
 */
public class StreamingPlayer {
    private String description;
    private String currentMedia;
    private boolean isPlaying;
    
    public StreamingPlayer(String description) {
        this.description = description;
        this.currentMedia = null;
        this.isPlaying = false;
    }
    
    public void turnOn() {
        System.out.println(description + " streaming player turning on");
    }
    
    public void turnOff() {
        System.out.println(description + " streaming player turning off");
    }
    
    public void play(String movie) {
        this.currentMedia = movie;
        this.isPlaying = true;
        System.out.println(description + " streaming player starting movie: " + movie);
    }
    
    public void playMusic(String album) {
        this.currentMedia = album;
        this.isPlaying = true;
        System.out.println(description + " streaming player starting album: " + album);
    }
    
    public void stop() {
        if (isPlaying && currentMedia != null) {
            System.out.println(description + " streaming player stopping: " + currentMedia);
            this.isPlaying = false;
        }
    }
}