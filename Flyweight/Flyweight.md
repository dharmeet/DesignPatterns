# Flyweight Pattern

## Intent
The Flyweight pattern minimizes memory usage by sharing as much data as possible with similar objects. It's particularly useful when an application needs to create a large number of similar objects.

## Problem
- Creating a large number of similar objects consumes excessive memory
- Object creation and initialization is expensive
- Many objects have duplicate state that could be shared

## Solution
The Flyweight pattern separates object data into:
1. **Intrinsic State**: Shared data stored in flyweight objects (e.g., character value)
2. **Extrinsic State**: Context-specific data passed by clients (e.g., position, font, size)

## Key Components

1. **Flyweight Interface**: Declares methods for receiving and acting on extrinsic state
2. **Concrete Flyweight**: Implements the flyweight interface and stores intrinsic state
3. **Flyweight Factory**: Creates and manages flyweight objects, ensuring sharing
4. **Client**: Maintains extrinsic state and uses flyweights

## Text Editor Example

Our example demonstrates a text editor system where:

- Each unique character is stored only once as a flyweight
- Character formatting and positioning (extrinsic state) is passed when needed
- A factory manages character creation and reuse

This significantly reduces memory usage when displaying large texts, as demonstrated in the output where we save memory by reusing character objects rather than creating new ones for each character in the text.

## Benefits

1. **Reduced Memory Usage**: Sharing objects reduces memory footprint
2. **Improved Performance**: Fewer objects mean less garbage collection
3. **Scalability**: Supports larger datasets with limited resources
4. **Centralized State Management**: Intrinsic state changes affect all clients

## Use Cases

- Text editors and word processors
- Game development (for terrain, particles, etc.)
- Graphics rendering systems
- Caching systems
- Any application dealing with large numbers of similar objects

## Implementation Considerations

- Identify which state can be made intrinsic vs. extrinsic
- Ensure flyweights are immutable (or protected from change)
- Carefully manage the flyweight factory to prevent duplication
- Consider thread safety for concurrent applications

## Java Standard Library Examples

- Java's `String` constant pool is an implementation of the Flyweight pattern
- Integer and other wrapper classes use flyweight caching for common values

## When to Use

- When an application uses a large number of objects
- When storage costs are high due to object quantity
- When most object state can be made extrinsic
- When removing shared state makes many groups of distinct objects replaceable by fewer shared objects

## Flyweight Pattern Explanation in PUBG Context

## In this implementation:

1. Intrinsic State (Shared)
BulletType class contains:
Texture/image path
Sound effect file
Damage value
Mass (physics property)
Size
2. Extrinsic State (Per-Instance)
Bullet class contains:
Position (x, y, z)
Direction
Speed
Active status
3. Memory Benefits
In a game like PUBG, thousands of bullets might be active simultaneously. Without the Flyweight pattern, each bullet would need to store its own copy of textures, sounds, and properties, consuming significant memory. By sharing these resources among all bullets of the same type, we drastically reduce memory usage.

4. Performance Improvements
Texture loading happens only once per bullet type
Fewer objects to garbage collect
Better cache locality due to smaller objects
This implementation allows a game to efficiently manage large numbers of bullets while keeping resource usage minimal - crucial for performance-intensive games like PUBG.