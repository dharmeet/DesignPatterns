package DesignPatterns.Prototype;

// The Prototype interface
// The Cloneable interface is used to indicate that a class can be cloned
// it is a marker interface, meaning it does not contain any methods.
// The clone() method is defined in the Object class and is used to create a copy of the object.
public interface Document extends Cloneable {
    Document clone();
    void print();
}