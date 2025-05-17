package DesignPatterns.Flyweight;

public class FlyweightDemo {
    public static void main(String[] args) {
        long startTime, endTime;
        
        // First, let's demonstrate the memory savings
        String text = "This is a sample text with some repeated characters. " +
                      "In a real text editor, there would be thousands of characters.";
        
        System.out.println("Creating a text editor with the text:");
        System.out.println(text);
        
        startTime = System.currentTimeMillis();
        TextEditor editor = new TextEditor(text, "Arial", 12);
        editor.display();
        endTime = System.currentTimeMillis();
        
        System.out.println("\nTotal unique character objects created: " + 
                          CharacterFactory.getObjectCount());
        System.out.println("Total characters in text: " + text.length());
        System.out.println("Memory saved: " + 
                          (text.length() - CharacterFactory.getObjectCount()) + 
                          " character objects");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
        
        // Now let's create a second document with some of the same characters
        System.out.println("\n--------------------------------");
        String text2 = "Another text with many of the same characters!";
        
        System.out.println("\nCreating another text editor with the text:");
        System.out.println(text2);
        
        startTime = System.currentTimeMillis();
        TextEditor editor2 = new TextEditor(text2, "Times New Roman", 14);
        editor2.display();
        endTime = System.currentTimeMillis();
        
        System.out.println("\nTotal unique character objects after second document: " + 
                          CharacterFactory.getObjectCount());
        System.out.println("Total characters in both texts: " + 
                          (text.length() + text2.length()));
        System.out.println("Memory saved overall: " + 
                          ((text.length() + text2.length()) - CharacterFactory.getObjectCount()) + 
                          " character objects");
        System.out.println("Time taken for second document: " + (endTime - startTime) + "ms");
    }
}