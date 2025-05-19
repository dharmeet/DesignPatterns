package DesignPatterns.Observer;

/**
 * Another concrete Observer that displays the heat index
 */
public class HeatIndexDisplay implements Observer, DisplayElement {
    private float heatIndex = 0.0f;
    private Subject weatherData;
    
    public HeatIndexDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update(float temperature, float humidity, float pressure) {
        heatIndex = computeHeatIndex(temperature, humidity);
        display();
    }
    
    /**
     * Calculate heat index based on temperature and humidity
     */
    private float computeHeatIndex(float t, float rh) {
        // This is a simplified heat index formula
        return (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh)));
    }
    
    @Override
    public void display() {
        System.out.println("Heat index: " + heatIndex);
    }
}