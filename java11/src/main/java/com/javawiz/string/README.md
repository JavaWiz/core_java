### Overview
Oracle released Java 11 in September 2018, only 6 months after its predecessor, version 10.

Java 11 is the first long-term support (LTS) release after Java 8. Oracle also stopped supporting Java 8 in January 2019. As a consequence, a lot of us will upgrade to Java 11.

We'll take a look at our options for choosing a Java 11 JDK. Then we'll explore new features, removed features, and performance enhancements introduced in Java 11.

### Developer Features
Let's take a look at changes to the common APIs, as well as a few other features useful for developers.

#### Running Java File with single command
One major change is that you don’t need to compile the java source file with javac tool first. You can directly run the file with java command and it implicitly compiles.
This feature comes under JEP 330.

#### New String Methods
Java 11 adds a few new methods to the String class: `isBlank`, `lines`, `strip`, `stripLeading`, `stripTrailing`, and `repeat`.

Let's see how we can make use of the new methods to extract non-blank, stripped lines from a multi-line string:
```
String multilineString = "Baeldung helps \n \n developers \n explore Java.";
List<String> lines = multilineString.lines()
.filter(line -> !line.isBlank())
.map(String::strip)
.collect(Collectors.toList());
assertThat(lines).containsExactly("Baeldung helps", "developers", "explore Java.");
```
These methods can reduce the amount of boilerplate involved in manipulating string objects, and save us from having to import libraries.

In the case of the strip methods, they provide similar functionality to the more familiar trim method; however, with finer control and Unicode support.

#### Collection to an Array
The `java.util.Collection` interface contains a new default `toArray` method which takes an `IntFunction` argument.

This makes it easier to create an array of the right type from a collection:
```
List sampleList = Arrays.asList("Java", "Kotlin");
String[] sampleArray = sampleList.toArray(String[]::new);
assertThat(sampleArray).containsExactly("Java", "Kotlin");
```

#### The Not Predicate Method
A static not method has been added to the Predicate interface. We can use it to negate an existing predicate, much like the negate method:
```
List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
List withoutBlanks = sampleList.stream()
.filter(Predicate.not(String::isBlank))
.collect(Collectors.toList());
assertThat(withoutBlanks).containsExactly("Java", "Kotlin");
```
While not(isBlank) reads more naturally than isBlank.negate(), the big advantage is that we can also use not with method references, like not(String:isBlank).

#### Local-Variable Syntax for Lambda
Support for using the local variable syntax (var keyword) in lambda parameters was added in Java 11.

We can make use of this feature to apply modifiers to our local variables, like defining a type annotation:
```
List<String> sampleList = Arrays.asList("Java", "Kotlin");
String resultString = sampleList.stream()
.map((@Nonnull var x) -> x.toUpperCase())
.collect(Collectors.joining(", "));
assertThat(resultString).isEqualTo("JAVA, KOTLIN");
```

#### HTTP Client
The new HTTP client from the java.net.http package was introduced in Java 9. It has now become a standard feature in Java 11.

The new HTTP API improves overall performance and provides support for both HTTP/1.1 and HTTP/2:
```
HttpClient httpClient = HttpClient.newBuilder()
.version(HttpClient.Version.HTTP_2)
.connectTimeout(Duration.ofSeconds(20))
.build();
HttpRequest httpRequest = HttpRequest.newBuilder()
.GET()
.uri(URI.create("http://localhost:" + port))
.build();
HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
assertThat(httpResponse.body()).isEqualTo("Hello from the server!");
```
#### A No-Op Garbage Collector
A new garbage collector called Epsilon is available for use in Java 11 as an experimental feature.

It's called a No-Op (no operations) because it allocates memory but does not actually collect any garbage. Thus, Epsilon is applicable for simulating out of memory errors.

Obviously Epsilon won't be suitable for a typical production Java application; however, there are a few specific use-cases where it could be useful:
* Performance testing
* Memory pressure testing
* VM interface testing and
* Extremely short-lived jobs

In order to enable it, use the `-XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC` flag.
























