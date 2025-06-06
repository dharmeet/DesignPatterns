package DesignPatterns.Flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight Factory
public class CharacterFactory {
    private static final Map<Character, CharacterInterface> characters = new HashMap<>();
    
    public static CharacterInterface getCharacter(char symbol) {
        // Return cached flyweight if it exists
        if (characters.containsKey(symbol)) {
            return characters.get(symbol);
        }
        
        // Create new flyweight if it doesn't exist
        System.out.println("Creating new character object for: " + symbol);
        CharacterInterface character = new CharacterImpl(symbol);
        characters.put((symbol), character);
        return character;
    }
    
    public static int getObjectCount() {
        return characters.size();
    }
}