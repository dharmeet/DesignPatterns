package DesignPatterns.Decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        System.out.println("===== Coffee Shop Ordering System =====\n");
        
        // 1. Basic coffee
        Beverage simpleCoffee = new BaseCoffee();
        printBeverageDetails("Simple Coffee Order", simpleCoffee);
        
        // 2. Coffee with milk
        Beverage coffeeWithMilk = new MilkDecorator(new BaseCoffee());
        printBeverageDetails("Coffee with Milk", coffeeWithMilk);
        
        // 3. Coffee with milk and sugar
        Beverage sweetCoffeeWithMilk = new SugarDecorator(new MilkDecorator(new BaseCoffee()));
        printBeverageDetails("Sweet Coffee with Milk", sweetCoffeeWithMilk);
        
        // 4. Fancy coffee with multiple decorators
        Beverage fancyCoffee = new WhippedCreamDecorator(
                                new CinnamonDecorator(
                                    new MilkDecorator(
                                        new BaseCoffee())));
        printBeverageDetails("Fancy Coffee", fancyCoffee);
        
        // 5. Custom espresso order
        Beverage fancyEspresso = new WhippedCreamDecorator(
                                  new SugarDecorator(
                                      new MilkDecorator(
                                          new Espresso())));
        printBeverageDetails("Fancy Espresso", fancyEspresso);
        
        // 6. Double milk coffee!
        Beverage doubleMilkCoffee = new MilkDecorator(
                                     new MilkDecorator(
                                         new BaseCoffee()));
        printBeverageDetails("Double Milk Coffee", doubleMilkCoffee);
        
        System.out.println("\n===== Benefits of Decorator Pattern =====");
        System.out.println("1. We can add any combination of condiments");
        System.out.println("2. New beverages or condiments can be added without changing existing code");
        System.out.println("3. Calculated costs dynamically based on exactly what was ordered");
        System.out.println("4. Avoided class explosion (no need for classes like CoffeeWithMilk, CoffeeWithMilkAndSugar, etc.)");
    }
    
    private static void printBeverageDetails(String orderName, Beverage beverage) {
        System.out.println(orderName + ":");
        System.out.println("  Description: " + beverage.getDescription());
        System.out.println("  Cost: $" + String.format("%.2f", beverage.getCost()));
        System.out.println();
    }
}