# Builder Pattern

## Intent
The Builder pattern separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

## Problem
How do you create a complex object with many parameters, some of which might be optional, without making the constructor unwieldy?

## Solution
Extract the object construction code out of its own class and move it to separate objects called builders.

## Key Components

1. **Builder**: An interface that defines all the steps to build a product. We have it in HttpRequest.Builder inner class, acting both as abstract Builder interface and Concrete Builder.
2. **ConcreteBuilder**: Implements the Builder interface and provides specific implementations for the building steps. HttpRequest.Builder in our case.
3. **Director**: Controls the building process using the builder interface (optional), the BuilderDemo is acting as the Director.
4. **Product**: The complex object being built. In our example it is HttpRequest.

## Benefits

- Allows you to create different representations of an object using the same construction code
- Isolates complex construction code from the business logic
- Provides better control over the construction process
- Eliminates the need for telescoping constructors

## Example Use Case

In this example, we use the Builder pattern to construct HTTP requests. The `HttpRequest` class represents a complex object with multiple optional parameters:

- URL (required)
- HTTP method (GET, POST, etc.)
- Headers
- Body content
- Connection timeout
- Whether to follow redirects

Using the Builder pattern makes creating HTTP requests clean and readable, even when setting many optional parameters. It also ensures the `HttpRequest` objects are immutable once constructed.

### Usage Example

```java
// Simple GET request
HttpRequest getRequest = new HttpRequest.Builder("https://api.example.com/users")
        .build();

// Complex POST request with headers and body
HttpRequest postRequest = new HttpRequest.Builder("https://api.example.com/users")
        .method("POST")
        .addHeader("Content-Type", "application/json")
        .addHeader("Authorization", "Bearer token123")
        .body("{\"name\":\"John Doe\",\"email\":\"john@example.com\"}")
        .timeout(60)
        .followRedirects(false)
        .build();
```

## When to Use

- When object construction involves multiple steps
- When the algorithm for creating a complex object should be independent of the parts that make up the object
- When you need different representations of the same construction process
- When you want to create immutable objects with many optional parameters