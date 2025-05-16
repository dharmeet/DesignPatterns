package DesignPatterns.Prototype;

import java.util.HashMap;
import java.util.Map;

public class DocumentRegistry {
    private Map<String, Document> prototypes = new HashMap<>();
    
    // Initialize with some default prototypes
    public DocumentRegistry() {
        prototypes.put("text", new TextDocument("Default Text", "Normal"));
        prototypes.put("spreadsheet", new SpreadsheetDocument(10, 10, "Default Data"));
    }
    
    public Document getClone(String type) {
        Document prototype = prototypes.get(type);
        if (prototype == null) {
            throw new IllegalArgumentException("Prototype not found for type: " + type);
        }
        return prototype.clone();
    }
    
    // Add a new prototype or replace an existing one
    public void registerPrototype(String type, Document prototype) {
        prototypes.put(type, prototype);
    }
    
    // Get all prototype types
    public String[] getPrototypeTypes() {
        return prototypes.keySet().toArray(new String[0]);
    }
}