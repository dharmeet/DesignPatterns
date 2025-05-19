# Facade Design Pattern

## Intent
The Facade pattern provides a unified, higher-level interface to a set of interfaces in a subsystem, making the subsystem easier to use.

## Problem
- A complex subsystem with many components is difficult for clients to understand and use
- Clients become tightly coupled to subsystem classes
- There are complex dependencies between clients and subsystem implementations
- You want to structure a subsystem into layers

## Solution
The Facade pattern introduces a new interface that:
1. Provides a simple interface to a complex subsystem
2. Doesn't hide the subsystem from clients who need direct access
3. Decouples the subsystem from its clients

## Key Components

1. **Facade**: Provides a simplified interface to the subsystem (HomeTheaterFacade)
2. **Subsystem Classes**: Complex implementation classes handled by the facade (TV, SoundSystem, etc.)
3. **Client**: Uses the facade to interact with the subsystem

## Benefits

1. **Simplification**: Reduces complexity for most client use cases
2. **Decoupling**: Minimizes dependencies between client and subsystem
3. **Layering**: Helps organize systems into layers
4. **Encapsulation**: Hides implementation details of the subsystem, but not restriction.

## Home Theater Example

Our home theater example demonstrates how a facade can simplify complex operations by providing cohesive high-level methods like `watchMovie()` and `endMovie()`. Without the facade, clients would need to understand and coordinate multiple components:

```java
// Without Facade - Complex client code
lights.dim(30);
tv.turnOn();
projector.turnOn();
projector.setInput(tv);
soundSystem.turnOn();
soundSystem.setVolume(20);
soundSystem.setSurroundSound();
streamingPlayer.turnOn();
streamingPlayer.play(movie);

// With Facade - Simple client code
homeTheater.watchMovie(movie);
```

## When to Use

- When you need to provide a simple interface to a complex subsystem
- When there are many dependencies between clients and implementation classes
- When you want to layer your subsystem and provide entry points to each layer
- When you need to reduce tight coupling between client and subsystem components

## Real-World Examples

1. **JDBC API**: Hides database connection complexity behind a simple interface
2. **Web Frameworks**: Hide HTTP, routing, and request handling complexity
3. **Device Drivers**: Hide hardware interactions behind simplified interfaces
4. **Backend Systems**: Backend services that coordinate multiple microservices.

## Differences from Adapter: 
While both Facade and Adapter wrap other objects:
* Adapter makes incompatible interfaces work together
* Facade simplifies a complex interface without changing its capabilities

## Key Considerations

- A facade is not a replacement for proper system design
- The facade should not try to encapsulate all functionality; direct component access should remain possible
- Multiple facades can be created for different use cases of the same subsystem
- Facade is often combined with other patterns like Singleton when a single facade is needed

This implementation allows clients to interact with a complex home theater system through a simplified interface while maintaining access to individual components when needed.

## When to Choose Facade vs. Other Patterns:

**Facade:** When you need to simplify a complex subsystem.
**Adapter:** When you need to make incompatible interfaces work together.
**Decorator:** When you need to add responsibilities to objects dynamically.