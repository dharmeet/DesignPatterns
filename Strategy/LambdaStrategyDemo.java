package DesignPatterns.Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaStrategyDemo {
    
    // Strategy interface as a functional interface
    @FunctionalInterface
    interface FilterStrategy<T> {
        boolean test(T t);
    }
    
    // Alternative using built-in Predicate
    static class ProductFilter {
        public static List<Product> filterProducts(List<Product> products, Predicate<Product> strategy) {
            List<Product> result = new ArrayList<>();
            for (Product product : products) {
                if (strategy.test(product)) {
                    result.add(product);
                }
            }
            return result;
        }
    }
    
    static class Product {
        private String name;
        private double price;
        private String category;
        
        public Product(String name, double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }
        
        public String getName() { return name; }
        public double getPrice() { return price; }
        public String getCategory() { return category; }
        
        @Override
        public String toString() {
            return name + " ($" + price + ") - " + category;
        }
    }
    
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1299.99, "Electronics"));
        products.add(new Product("Headphones", 99.99, "Electronics"));
        products.add(new Product("Coffee Mug", 9.99, "Kitchen"));
        products.add(new Product("Desk", 349.99, "Furniture"));
        products.add(new Product("Monitor", 249.99, "Electronics"));
        
        System.out.println("=== Filtering with Lambda Strategies ===");
        
        // Using lambda expressions as strategies
        System.out.println("\nExpensive Products (>$200):");
        List<Product> expensiveProducts = ProductFilter.filterProducts(
            products, 
            product -> product.getPrice() > 200
        );
        expensiveProducts.forEach(System.out::println);
        
        // Another strategy with lambda
        System.out.println("\nElectronics Products:");
        List<Product> electronicsProducts = ProductFilter.filterProducts(
            products, 
            product -> product.getCategory().equals("Electronics")
        );
        electronicsProducts.forEach(System.out::println);
        
        // Method reference as strategy
        System.out.println("\nProducts sorted by special criteria:");
        List<Product> specialProducts = ProductFilter.filterProducts(
            products, 
            LambdaStrategyDemo::isSpecialProduct
        );
        specialProducts.forEach(System.out::println);
        
        // Combining strategies with logical operations
        System.out.println("\nAffordable Electronics:");
        List<Product> affordableElectronics = ProductFilter.filterProducts(
            products, 
            product -> product.getCategory().equals("Electronics") && product.getPrice() < 200
        );
        affordableElectronics.forEach(System.out::println);
    }
    
    // Method that can be used as a strategy via method reference
    private static boolean isSpecialProduct(Product product) {
        // Special logic that might be too complex for a simple lambda
        return product.getPrice() > 100 && product.getName().length() < 10;
    }
}