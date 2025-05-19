package DesignPatterns.Facade;

/**
 * Client code that uses the facade
 */
public class FacadeDemo {
    public static void main(String[] args) {
        // Create individual components of the home theater
        Television tv = new Television("Samsung 4K");
        SoundSystem soundSystem = new SoundSystem("Bose");
        StreamingPlayer streamingPlayer = new StreamingPlayer("Netflix");
        Lights lights = new Lights("Philips Hue");
        Projector projector = new Projector("Epson");
        
        // Create the facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
            tv, soundSystem, streamingPlayer, lights, projector);
        
        System.out.println("===== Home Theater System Demonstration =====\n");
        
        // Use the simplified facade interface to watch a movie
        homeTheater.watchMovie("Inception");
        
        System.out.println("\n=== [Two hours later...] ===\n");
        
        // End the movie
        homeTheater.endMovie();
        
        System.out.println("\n=== [Next day...] ===\n");
        
        // Use the facade to listen to music
        homeTheater.listenToMusic("Pink Floyd - Dark Side of the Moon");
        
        System.out.println("\n=== [One hour later...] ===\n");
        
        // End the music
        homeTheater.endMusic();
        
        System.out.println("\n===== Benefits of Facade Pattern =====");
        System.out.println("1. Client code is simplified - compare to raw component manipulation");
        System.out.println("2. Subsystem components are decoupled from clients");
        System.out.println("3. Common use cases are encapsulated in single method calls");
        System.out.println("4. Components can still be accessed directly if advanced operations are needed");
        
        // Example of direct component access when needed
        System.out.println("\n=== [Direct Component Access Example] ===");
        lights.dim(20);
        tv.turnOn();
        tv.setChannel(5);
    }
}