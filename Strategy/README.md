# Strategy Design Pattern

## Intent
The Strategy pattern defines a family of algorithms, encapsulates each algorithm, and makes them interchangeable. It lets the algorithm vary independently from clients that use it.

## Problem
- You need to support multiple algorithms or behaviors
- These behaviors should be interchangeable at runtime
- You want to avoid conditional statements (if/else, switch) for selecting behavior
- You want to isolate algorithm implementation details from code that uses the algorithm

## Solution
The Strategy pattern suggests:
1. Create a common strategy interface for all algorithms
2. Encapsulate each algorithm in a concrete strategy class
3. Make the context class contain a reference to the strategy interface
4. Allow clients to switch strategies at runtime

## Key Components

1. **Strategy Interface**: Declares operations common to all algorithms (PaymentStrategy)
2. **Concrete Strategies**: Implement the strategy interface with specific algorithms (CreditCardPayment, PayPalPayment, etc.)
3. **Context**: Maintains a reference to a strategy and delegates algorithm execution to it (ShoppingCart)
4. **Client**: Creates and configures the context with the desired strategy (StrategyDemo)

## Benefits

1. **Encapsulation**: Algorithms are isolated in separate classes
2. **Flexibility**: Algorithms can be swapped at runtime
3. **Elimination of Conditionals**: Removes complex conditional logic for selecting behaviors
4. **Open/Closed Principle**: New strategies can be added without modifying existing code
5. **Composition over Inheritance**: Uses object composition rather than inheritance for flexibility

## Design Considerations:

1. Strategy interfaces should be focused on a single responsibility.
2. Consider the impact of strategy switching on performance.
3. Decide whether to create strategies on-demand or reuse existing ones.

## Payment System Example

Our e-commerce payment system demonstrates the Strategy pattern by:

- Defining a common `PaymentStrategy` interface for all payment methods
- Creating concrete implementations for various payment methods (Credit Card, PayPal, Bitcoin)
- Using a `ShoppingCart` context that delegates payment processing to the selected strategy
- Allowing users to choose different payment methods at runtime

This approach provides several benefits:

- The shopping cart doesn't need to know details of payment processing
- New payment methods can be added without changing the shopping cart code
- Payment methods can be switched dynamically based on user preference

## When to Use

- When you want to define a family of interchangeable algorithms
- When you need to eliminate conditional statements for selecting behavior
- When different variants of an algorithm are needed
- When an algorithm uses data that clients shouldn't know about
- When a class defines many behaviors, and these appear as multiple conditional statements

## Implementation Approaches:

**Classic Implementation:** As shown in the example, with separate strategy classes.
**Function-based Implementation:** 
 In Java 8+, strategies can often be implemented as lambda expressions or method references

## Real-World Examples

1. **Payment Processing**: Various payment methods in e-commerce (our example)
2. **Sorting Algorithms**: Different sorting strategies based on data characteristics
3. **Compression Algorithms**: Different compression methods based on file type
4. **Route Navigation**: Different routing algorithms based on preferences (fastest, shortest, etc.)
5. **Authentication Mechanisms**: Different authentication strategies (password, 2FA, OAuth, etc.)

## Related Patterns

- **State**: Similar structure but with different intent - State allows an object to change its behavior when its internal state changes
- **Decorator**: Can be used with Strategy to enhance or modify the behavior of strategies
- **Factory Method**: Can be used to create the appropriate strategy
- **Template Method**: Defines the skeleton of an algorithm with some steps deferred to subclasses

The Strategy pattern promotes the "prefer composition over inheritance" principle and helps build flexible, maintainable systems with interchangeable components.