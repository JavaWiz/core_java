### Java 9 Features
Oracle has released Java 9 with rich set of new features. It includes various upgrades to the Java programming, JVM, Tools and libraries. We will discuss all the main features that are given below.
* Platform Module System (Project Jigsaw)
* Interface Private Methods
* Stream API Improvement
* Collection Factory Methods
* Try-With Resources
* JShell: The Java Shell (REPL)
* Anonymous Classes
* @SafeVarargs Annotation
* Process API Improvement
* New Version-String Scheme

### Java Platform Module System (Project Jigsaw)
Java Module System is a major change in Java 9 version. Java added this feature to collect Java packages and code into a single unit called module.

In earlier versions of Java, there was no concept of module to create modular Java applications, that why size of application increased and difficult to move around. Even JDK itself was too heavy in size, in Java 8, rt.jar file size is around 64MB.

To deal with situation, Java 9 restructured JDK into set of modules so that we can use only required module for our project.

Apart from JDK, Java also allows us to create our own modules so that we can develop module based application.

### Interface Private Methods
In Java 9, we can create private methods inside an interface. Interface allows us to declare private methods that help to share common code between non-abstract methods.

Before Java 9, creating private methods inside an interface cause a compile time error.

### Java 9 Stream API Improvement
In Java 9, Stream API has improved and new methods are added to the Stream interface. TakeWhile, dropWhile and ofNullable, and one overloaded iterate method are added to perform operations on stream elements.

### Java Collection Factory Methods
Factory methods are special type of static methods that are used to create unmodifiable instances of collections. It means we can use these methods to create list, set and map of small number of elements.

It is unmodifiable, so adding new element will throw `java.lang.UnsupportedOperationException`.

### Try-With Resources
Java introduced `try-with-resource` feature in Java 7 that helps to close resource automatically after being used.

In other words, we can say that we don't need to close resources (file, connection, network etc) explicitly, try-with-resource close that automatically by using AutoClosable interface.

In Java 7, try-with-resources has a limitation that requires resource to declare locally within its block.

### JShell: The Java Shell (REPL)
It is an interactive Java Shell tool, it allows us to execute Java code from the shell and shows output immediately. JShell is a REPL (Read Evaluate Print Loop) tool and run from the command line. It is benificial, if we want to test our business logic and get result immediately.

### Java @SafeVarargs Annotation
It is an annotation which applies on a method or constructor that takes varargs parameters. It is used to ensure that the method does not perform unsafe operations on its varargs parameters.

It was included in Java 7 and can only be applied on
* Final methods
* Static methods
* Constructors
























