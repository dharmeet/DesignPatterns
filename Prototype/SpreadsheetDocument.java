package DesignPatterns.Prototype;

public class SpreadsheetDocument implements Document {
    private int rows;
    private int columns;
    private String data;
    
    public SpreadsheetDocument(int rows, int columns, String data) {
        this.rows = rows;
        this.columns = columns;
        this.data = data;
        // Simulate expensive initialization
        try {
            Thread.sleep(1500); // Even more expensive initialization
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    // Copy constructor
    private SpreadsheetDocument(SpreadsheetDocument source) {
        this.rows = source.rows;
        this.columns = source.columns;
        this.data = source.data;
        // No expensive initialization needed during cloning
    }
    
    @Override
    public Document clone() {
        return new SpreadsheetDocument(this);
    }
    
    @Override
    public void print() {
        System.out.println("Spreadsheet Document: " + rows + "x" + columns + " [Data: " + data + "]");
    }
    
    public void setData(String data) {
        this.data = data;
    }
}