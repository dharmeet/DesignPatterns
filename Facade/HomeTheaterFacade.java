package DesignPatterns.Facade;

/**
 * The Facade class that provides a simplified interface to the complex subsystem
 */
public class HomeTheaterFacade {
    private Television tv;
    private SoundSystem soundSystem;
    private StreamingPlayer streamingPlayer;
    private Lights lights;
    private Projector projector;
    
    public HomeTheaterFacade(Television tv, SoundSystem soundSystem, 
                            StreamingPlayer streamingPlayer, 
                            Lights lights, Projector projector) {
        this.tv = tv;
        this.soundSystem = soundSystem;
        this.streamingPlayer = streamingPlayer;
        this.lights = lights;
        this.projector = projector;
    }
    
    /**
     * Single method to set up everything for watching a movie
     */
    public void watchMovie(String movie) {
        System.out.println("=== Setting up for movie night: " + movie + " ===");
        lights.dim(30);
        tv.turnOn();
        projector.turnOn();
        projector.setInput(tv);
        soundSystem.turnOn();
        soundSystem.setVolume(20);
        soundSystem.setSurroundSound();
        streamingPlayer.turnOn();
        streamingPlayer.play(movie);
    }
    
    /**
     * Single method to shut down everything after watching a movie
     */
    public void endMovie() {
        System.out.println("=== Shutting down home theater ===");
        streamingPlayer.stop();
        streamingPlayer.turnOff();
        soundSystem.turnOff();
        projector.turnOff();
        tv.turnOff();
        lights.brighten(100);
    }
    
    /**
     * Single method to set up for listening to music
     */
    public void listenToMusic(String album) {
        System.out.println("=== Setting up for music: " + album + " ===");
        lights.dim(50);
        soundSystem.turnOn();
        soundSystem.setVolume(15);
        soundSystem.setStereo();
        streamingPlayer.turnOn();
        streamingPlayer.playMusic(album);
    }
    
    /**
     * Single method to stop listening to music
     */
    public void endMusic() {
        System.out.println("=== Shutting down music ===");
        streamingPlayer.stop();
        streamingPlayer.turnOff();
        soundSystem.turnOff();
        lights.brighten(100);
    }
}