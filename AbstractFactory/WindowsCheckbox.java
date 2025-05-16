package DesignPatterns.AbstractFactory;

// Concrete product B1
public class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows-style checkbox");
    }
    
    @Override
    public void toggle() {
        System.out.println("Windows checkbox toggled");
    }
}