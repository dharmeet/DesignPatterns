package DesignPatterns.Prototype;

public class TextDocument implements Document {
    private String content;
    private String formatting;
    
    public TextDocument(String content, String formatting) {
        this.content = content;
        this.formatting = formatting;
        // Imagine this constructor does some expensive processing
        try {
            Thread.sleep(1000); // Simulating expensive initialization
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    // Copy constructor
    private TextDocument(TextDocument source) {
        this.content = source.content;
        this.formatting = source.formatting;
        // No expensive initialization needed during cloning
    }
    
    @Override
    public Document clone() {
        return new TextDocument(this);
    }
    
    @Override
    public void print() {
        System.out.println("Text Document: " + content + " [Formatting: " + formatting + "]");
    }
    
    public void setContent(String content) {
        this.content = content;
    }
}