package DesignPatterns.AbstractFactory;

// Concrete product B2
public class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a macOS-style checkbox");
    }
    
    @Override
    public void toggle() {
        System.out.println("macOS checkbox toggled");
    }
}