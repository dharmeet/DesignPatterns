# Decorator Pattern

## Intent
The Decorator pattern allows behaviors to be added to individual objects dynamically and transparently, without affecting other objects of the same class.

## Problem
- You need to add responsibilities to objects dynamically at runtime
- You want to avoid class explosion from using inheritance to add features
- You want to keep the Single Responsibility Principle by separating concerns

## Solution
The Decorator pattern uses composition and delegation instead of inheritance to extend functionality. It involves:

1. A common Component interface for both the core object and decorators
2. Concrete Components implementing the base functionality
3. A base Decorator class that implements the Component interface and holds a reference to a Component
4. Concrete Decorators that add specific behaviors

## Key Components

1. **Component**: The interface defining operations that can be altered by decorators (Beverage)
2. **Concrete Component**: The core object being wrapped (BaseCoffee, Espresso)
3. **Base Decorator**: Abstract class that implements Component and contains a reference to a Component (BeverageDecorator)
4. **Concrete Decorator**: Adds specific responsibilities to the component (MilkDecorator, SugarDecorator, etc.)

## Benefits

1. **Flexibility**: More flexible than static inheritance
2. **Open/Closed Principle**: Functionality can be extended without modifying existing code
3. **Single Responsibility**: Classes focus on single responsibility, with decorators handling additional behaviors
4. **Runtime Configuration**: Object features can be configured at runtime
5. **Composition over Inheritance**: Solves problems of class explosion in pure inheritance approaches

## Coffee Example

Our coffee shop example demonstrates how the Decorator pattern allows:

- Creating simple coffees with base functionality
- "Decorating" coffees with condiments (milk, sugar, cinnamon, etc.)
- Maintaining the original interface while extending behavior
- Calculating the price dynamically based on the exact combination of decorators

This mirrors real-world coffee shops where you can add any combination of extras to a basic beverage.

## Real-World Use Cases

1. **Java I/O**: Java's I/O classes use the Decorator pattern extensively (BufferedInputStream, DataInputStream, etc.)

```java
// Creates a buffered reader for efficient reading with character conversion
new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")));
```

2. **UI Components**: Adding behaviors like scrolling, borders to UI components
3. **Web Development**: Adding features to web services like authentication, logging, caching
4. **Game Development**: Adding powers or abilities to characters

## When to Use

- When you need to add responsibilities to objects dynamically and transparently
- When extension by subclassing is impractical due to class explosion
- When you need to combine multiple behaviors in different ways
- When you want to separate concerns with the single responsibility principle