package DesignPatterns.Observer;

/**
 * Main demo to test the Observer pattern
 */
public class ObserverDemo {
    public static void main(String[] args) {
        // Create the subject (observable)
        WeatherData weatherData = new WeatherData();
        
        System.out.println("===== Weather Station System =====\n");
        
        // Create and register observers
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        
        // First weather update
        System.out.println("--- Weather Update 1 ---");
        weatherData.setMeasurements(27.5f, 65.0f, 30.4f);
        
        // Second weather update
        System.out.println("\n--- Weather Update 2 ---");
        weatherData.setMeasurements(28.2f, 70.0f, 29.92f);
        
        // Add a new observer dynamically
        System.out.println("\n--- Adding Heat Index Display ---");
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
        
        // Third weather update (now with the new observer)
        System.out.println("\n--- Weather Update 3 ---");
        weatherData.setMeasurements(30.8f, 90.0f, 29.2f);
        
        // Remove an observer dynamically
        System.out.println("\n--- Removing Current Conditions Display ---");
        currentDisplay.unregister();
        
        // Fourth weather update (without the removed observer)
        System.out.println("\n--- Weather Update 4 ---");
        weatherData.setMeasurements(25.3f, 55.0f, 31.5f);
        
        System.out.println("\n===== Benefits of Observer Pattern =====");
        System.out.println("1. Loose coupling between subject and observers");
        System.out.println("2. Support for broadcast communication");
        System.out.println("3. Dynamic relationships established at runtime");
        System.out.println("4. Observers can be added or removed at any time");
    }
}