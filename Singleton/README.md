Singleton Patten: Ensures that class has only one instance and provide a global access point to it.
Following are some of the applications of SingletonPattern:
1. Logging Service
2. Configuration Manager
3. Connection Pool Manager
4. Thread Pool Manager
5. Caching Mechanism
6. Load Balancer
7. File System Manager
8. Game Manager -> Game state manager to track scores, levels and settings.

Following commands to build and run:
1. cd C:\DesignPatterns
2.  javac Singleton\*.java
3. java -cp c:\ DesignPatterns.Singleton.SingletonDemo

Key points here:
1. Use the -cp (classpath) parameter to point to the root directory
2. Use the fully qualified class name including the package path
3. Make sure each Java file has the correct package declaration

What is Reflection in Java?
Reflection is a Java API that enables examining, modifying, and manipulating classes, interfaces, fields, and methods at runtime. It allows code to:

1. Discover and use class members regardless of access modifiers (public, private, protected)
2. Create new instances of classes without direct constructor access
3. Invoke methods by name at runtime
4. Modify field values, even if they're private or final
5. Examine class metadata (annotations, implemented interfaces, etc.)

For the DoubleCheckLocking and BillPugh following can be done to create instance. 
`
Constructor<DoubleCheckLockingSingleton> constructor = 
    DoubleCheckLockingSingleton.class.getDeclaredConstructor();
constructor.setAccessible(true);
DoubleCheckLockingSingleton secondInstance = constructor.newInstance();

`

Reflection is commonly used in frameworks (Spring, Hibernate), serialization libraries, testing tools, and other scenarios requiring dynamic inspection or modification of code structures.

Among the three implementations:

1. Double-Check Locking: Vulnerable to reflection (with some protection)
2. BillPugh: Vulnerable to reflection (without protection in current form)
3. Enum: Completely immune to reflection attacks.

The Enum implementation is immune because Java guarantees that enum values are instantiated only once, and the JVM explicitly prevents creating new instances of enum types via reflection - attempting to do so will throw an IllegalArgumentException.