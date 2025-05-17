package DesignPatterns.Flyweight;

// Concrete Flyweight - stores intrinsic state (character value)
public class CharacterImpl implements Character {
    private final char symbol;
    
    public CharacterImpl(char symbol) {
        this.symbol = symbol;
        // Simulate resource-intensive initialization
        try {
            Thread.sleep(100); // Pretend each character takes time to create
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void display(String font, int size, int x, int y) {
        System.out.println("Character '" + symbol + "' with " + font + 
                           ", size " + size + " at position (" + x + ", " + y + ")");
    }
}