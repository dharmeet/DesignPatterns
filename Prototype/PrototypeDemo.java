package DesignPatterns.Prototype;

public class PrototypeDemo {
    public static void main(String[] args) {
        // Create the registry with default prototypes
        DocumentRegistry registry = new DocumentRegistry();
        
        System.out.println("Available prototype types: ");
        for (String type : registry.getPrototypeTypes()) {
            System.out.println("- " + type);
        }
        
        // Measure time for original object creation vs cloning
        long startTime = System.currentTimeMillis();
        TextDocument originalDoc = new TextDocument("Original Content", "Bold");
        long endTime = System.currentTimeMillis();
        System.out.println("\nCreating new TextDocument took " + (endTime - startTime) + "ms");
        
        // Get and customize clones from the registry
        startTime = System.currentTimeMillis();
        TextDocument textDoc1 = (TextDocument) registry.getClone("text");
        textDoc1.setContent("Custom Report Content");
        endTime = System.currentTimeMillis();
        System.out.println("Cloning TextDocument took " + (endTime - startTime) + "ms");
        
        SpreadsheetDocument spreadsheetDoc = (SpreadsheetDocument) registry.getClone("spreadsheet");
        spreadsheetDoc.setData("Q1 Sales Data");
        
        // Register a custom prototype
        registry.registerPrototype("custom-text", 
            new TextDocument("Template for Marketing", "Fancy"));
        
        // Clone the custom prototype
        TextDocument customTextDoc = (TextDocument) registry.getClone("custom-text");
        
        // Print all documents
        System.out.println("\nDocument Contents:");
        originalDoc.print();
        textDoc1.print();
        spreadsheetDoc.print();
        customTextDoc.print();
    }
}