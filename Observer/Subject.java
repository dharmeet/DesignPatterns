package DesignPatterns.Observer;

/**
 * The Subject interface defines operations for attaching, detaching,
 * and notifying observers
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
