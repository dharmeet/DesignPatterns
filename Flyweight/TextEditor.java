package DesignPatterns.Flyweight;

// Client
public class TextEditor {
    private final String text;
    private final String font;
    private final int fontSize;
    
    public TextEditor(String text, String font, int fontSize) {
        this.text = text;
        this.font = font;
        this.fontSize = fontSize;
    }
    
    public void display() {
        int x = 0;
        int y = 0;
        int lineLength = 0;
        
        System.out.println("\nDisplaying text: \"" + text + "\"");
        
        for (char symbol : text.toCharArray()) {
            // Handle line breaks
            if (symbol == '\n') {
                y += fontSize;
                x = 0;
                lineLength = 0;
                continue;
            }
            
            // Handle horizontal positioning
            if (lineLength >= 60) { // Arbitrary line length
                y += fontSize;
                x = 0;
                lineLength = 0;
            }
            
            // Get flyweight character
            Character character = CharacterFactory.getCharacter(symbol);
            
            // Display with extrinsic state (font, size, position)
            character.display(font, fontSize, x, y);
            
            // Move to next position
            x += fontSize/2;
            lineLength++;
        }
    }
}