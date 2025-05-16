# Prototype Pattern & Prototype Registry

## Intent
The Prototype pattern creates new objects by copying existing ones, avoiding complex object creation from scratch. The Prototype Registry extends this by centrally storing prototypes.

## Problem
- Creating certain objects is expensive or complex
- You need many objects with similar or identical state
- You want to reduce subclassing
- Classes to instantiate are specified at runtime

## Solution
Declare a common interface for all prototype objects that supports cloning. Create a registry to store and retrieve prototype instances.

## Key Components

1. **Prototype**: An interface that declares the cloning method - Document.java
2. **Concrete Prototype**: Classes that implement the prototype interface - TextDocument.java, SpreadsheetDocument.java
3. **Prototype Registry**: Stores and manages prototype instances - DocumentRegistry.java
4. **Client**: Creates new objects by asking prototypes to clone themselves - PrototypeDemo.java

## Benefits

- Hides complexity of creating new instances
- Provides alternative to subclassing
- Allows adding/removing products at runtime
- Configures application with classes dynamically
- Reduces initialization overhead
- Creates pre-configured objects

## Document System Example

Our example demonstrates a document management system with two document types:

- **TextDocument**: Represents text files with content and formatting
- **SpreadsheetDocument**: Represents spreadsheets with rows, columns, and data

Each document type has expensive initialization (simulated with sleep). The Prototype pattern allows us to create pre-initialized templates and then quickly clone them when needed.

The DocumentRegistry manages these prototypes, allowing:
- Retrieving and cloning prototypes by name
- Registering new prototypes
- Getting a list of available prototype types

### Performance Benefit

Creating the original document takes approximately 1000ms due to expensive initialization. Cloning an existing document takes just a few milliseconds, demonstrating the performance advantage of the Prototype pattern for complex objects.

## When to Use

- When a system should be independent of how products are created
- When classes to instantiate are specified at runtime
- To avoid building a factory hierarchy parallel to the product hierarchy
- When objects have few variations in state, and it's more convenient to copy an existing object than creating a new one
- Examples : 
   1. GameDevelopment (Cloning game objects like characters, weapons, environment).
   2. Document Management (Cloning templates like invoices, resume, MS Word, Google Docs.)
   3. DBEntity Cloning
   4. Distributed Systems and Microservices (configurable instances)
   5. WebFrameworks and Backend Development (SpringBoot and .NET Core uses prototype based Dependency Injection.)