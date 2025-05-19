package DesignPatterns.Observer;

/**
 * The Observer interface defines the update method that is called
 * when the subject changes
 */
public interface Observer {
    void update(float temperature, float humidity, float pressure);
}