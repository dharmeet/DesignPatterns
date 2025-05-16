package DesignPatterns.AbstractFactory;

// Abstract factory
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}