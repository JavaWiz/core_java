JDK 10, which is an implementation of Java SE 10, was released on March 20, 2018.

#### Local Variable Type Inference
One of the most visible enhancements in JDK 10 is type inference of local variables with initializers.

Until Java 9, we had to mention the type of the local variable explicitly and ensure it was compatible with the initializer used to initialize it:
```
String message = "Good bye, Java 9";
```
In Java 10, this is how we could declare a local variable:
```
@Test
public void whenVarInitWithString_thenGetStringTypeVar() {
var message = "Hello, Java 10";
assertTrue(message instanceof String);
}
```
**We don't provide the data type of message. Instead, we mark the message as a var, and the compiler infers the type of message from the type of the initializer present on the right-hand side.**

In above example, the type of message would be String.

Note that this feature is available only for local variables with the initializer. It cannot be used for `member variables`, `method parameters`, `return types`, etc – the initializer is required as without which compiler won't be able to infer the type.

This enhancement helps in reducing the boilerplate code; for example:
```
Map<Integer, String> map = new HashMap<>();
```
This can now be rewritten as:
```
var idToNameMap = new HashMap<Integer, String>();
```
This also helps to focus on the variable name rather than on the variable type.

Another thing to note is that **var is not a keyword** – this ensures backward compatibility for programs using var say, as a function or variable name. var is a reserved type name, just like int.

Finally, note that there is **no runtime overhead in using var nor does it make Java a dynamically typed language**. The type of the variable is still inferred at compile time and cannot be changed later.

### Illegal Use of var
As mentioned earlier, var won't work without the initializer:
```
var n; // error: cannot use 'var' on variable without initializer
```
Nor would it work if initialized with null:
```
var emptyList = null; // error: variable initializer is 'null'
```
It won't work for non-local variables:
```
public var = "hello"; // error: 'var' is not allowed here
```
Lambda expression needs explicit target type, and hence var cannot be used:
```
var p = (String s) -> s.length() > 10; // error: lambda expression needs an explicit target-type
```
Same is the case with the array initializer:
```
var arr = { 1, 2, 3 }; // error: array initializer needs an explicit target-type
```

#### Unmodifiable Collections
There are a couple of changes related to unmodifiable collections in Java 10.

**copyOf()**

`java.util.List`, `java.util.Map` and `java.util.Set` each got a new static method `copyOf(Collection)`.

It returns the unmodifiable copy of the given Collection:
```
@Test(expected = UnsupportedOperationException.class)
public void whenModifyCopyOfList_thenThrowsException() {
List<Integer> copyList = List.copyOf(someIntList);
copyList.add(4);
}
```
Any attempt to modify such a collection would result in `java.lang.UnsupportedOperationException` runtime exception.

#### toUnmodifiable*()

`java.util.stream.Collectors` get additional methods to collect a Stream into unmodifiable List, Map or Set:
```
@Test(expected = UnsupportedOperationException.class)
public void whenModifyToUnmodifiableList_thenThrowsException() {
List<Integer> evenList = someIntList.stream()
.filter(i -> i % 2 == 0)
.collect(Collectors.toUnmodifiableList());
evenList.add(4);
}
```
Any attempt to modify such a collection would result in `java.lang.UnsupportedOperationException` runtime exception.

#### Optional*.orElseThrow()

`java.util.Optional`, `java.util.OptionalDouble`, `java.util.OptionalInt` and `java.util.OptionalLong` each got a new method `orElseThrow()` which doesn't take any argument and throws `NoSuchElementException` if no value is present:
```
@Test
public void whenListContainsInteger_OrElseThrowReturnsInteger() {
Integer firstEven = someIntList.stream()
.filter(i -> i % 2 == 0)
.findFirst()
.orElseThrow();
is(firstEven).equals(Integer.valueOf(2));
}
```
It's synonymous with and is now the preferred alternative to the existing `get()` method.

### Performance Improvements
We will discuss the performance improvements that come along with the latest Java 10 release.

These improvements apply to all applications running under JDK 10, with no need for any code changes to leverage them.

#### Parallel Full GC for G1
The G1 garbage collector is the default one since JDK 9. However, the full GC for G1 used a single threaded mark-sweep-compact algorithm.

This has been changed to the parallel mark-sweep-compact algorithm in Java 10 effectively reducing the stop-the-world time during full GC.

#### Application Class-Data Sharing
Class-Data Sharing, introduced in JDK 5, allows a set of classes to be pre-processed into a shared archive file that can then be memory-mapped at runtime to reduce startup time which can also reduce dynamic memory footprint when multiple JVMs share the same archive file.

CDS only allowed the bootstrap class loader, limiting the feature to system classes only. Application CDS (AppCDS) extends CDS to allow the built-in system class loader (a.k.a., the “app class loader”), the built-in platform class loader, and custom class loaders to load archived classes. This makes it possible to use the feature for application classes.

#### Get the list of classes to archive

The following command will dump the classes loaded by the HelloWorld application into hello.lst:

$ java -Xshare:off -XX:+UseAppCDS -XX:DumpLoadedClassList=hello.lst \
-cp hello.jar HelloWorld
2. Create the AppCDS archive



### Container Awareness
JVMs are now aware of being run in a Docker container and will extract container-specific configuration instead of querying the operating system itself – it applies to data like the number of CPUs and total memory that have been allocated to the container.

However, this support is only available for Linux-based platforms. This new support is enabled by default and can be disabled in the command line with the JVM option:
```
-XX:-UseContainerSupport
```
Also, this change adds a JVM option that provides the ability to specify the number of CPUs that the JVM will use:
```
-XX:ActiveProcessorCount=count
```
Also, three new JVM options have been added to allow Docker container users to gain more fine-grained control over the amount of system memory that will be used for the Java Heap:
```
-XX:InitialRAMPercentage
-XX:MaxRAMPercentage
-XX:MinRAMPercentage
```








