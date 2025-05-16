package DesignPatterns.AbstractFactory;

// Client
public class Application {
    private Button button;
    private Checkbox checkbox;
    
    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }
    
    public void createUI() {
        button.render();
        checkbox.render();
    }
    
    public void simulateUserInteraction() {
        button.onClick();
        checkbox.toggle();
    }
}