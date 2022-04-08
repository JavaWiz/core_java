## Java Stream collect() Method Examples
This is a terminal operation. It allows us to perform mutable fold operations (repackaging elements to some data structures and applying some additional logic, concatenating them, etc.) on data elements held in a Stream instance.

The strategy for this operation is provided via the Collector interface implementation.

### Java Stream collect() Method Signature
There are two variants of Java Stream collect() method.
```
<R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator,BiConsumer<R, R> combiner)
<R, A> R collect(Collector<? super T, A, R> collector)
```
The Collector is an interface that provides a wrapper for the supplier, accumulator, and combiner objects. The second method is useful when we are utilizing the Collectors class to provide built-in Collector implementation.

The three parameters of the collect() function are:

* Supplier: A function that creates a new mutable result container. For the parallel execution, this function may be called multiple times, and it must return a fresh value each time.
* Accumulator: A stateless function that must fold an element into a result container.
* Combiner: A stateless function that accepts two partial result containers and merges them, which must be compatible with the accumulator function.

### Stream collect() Method Examples
#### Concatenating List of Strings
Let’s say you want to concatenate the list of strings to create a new string. We can use Stream collect() function to perform a mutable reduction operation and concatenate the list elements.
```
List<String> vowels = List.of("a", "e", "i", "o", "u");
// sequential stream - nothing to combine
StringBuilder result = vowels.stream().collect(StringBuilder::new, StringBuilder::append,
      (a, b) -> a.append(",").append(b));
System.out.println(result.toString());

// parallel stream - combiner is combining partial results
StringBuilder result1 = vowels.parallelStream().collect(StringBuilder::new, StringBuilder::append,
      (a, b) -> a.append(",").append(b));
System.out.println(result1.toString());
```
Output
```
aeiou
a,e,i,o,u
```
* The supplier function is returning a new StringBuilder object in every call.
* The accumulator function is appending the list string element to the StringBuilder instance.
* The combiner function is merging the StringBuilder instances. The instances are merged with each other with a comma between it.
* In the first case, we have a sequential stream of elements. So they are processed one by one and there is only one instance of StringBuilder. There is no use of the combiner function. That’s why the output produced is “aeiou”.
* In the second case, we have a parallel stream of strings. So, the elements are processed parallelly and there are multiple instances of StringBuilder that are being merged by the combiner function. Hence, the output produced is “a,e,i,o,u”.
* If the stream source is ordered such as List, the collect() method maintains the order while processing. If the stream source is unordered such as Set, then the collect() method can produce different results in each invocation.

#### Stream collect() to List using Collectors Class
we will filter the list of integers to select only even integers. Stream `filter()` is an intermediate operation and returns a stream. So, we will use the `collect()` function to create the list from this stream.
```
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
		
List<Integer> evenNumbers = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
System.out.println(evenNumbers);  // [2, 4, 6]
```
The Collectors.toList() returns a Collector implementation that accumulates the input elements into a new List.

#### Stream collect() to a Set
We can use Collectors.toSet() to collect the stream elements into a new Set.
```
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
Set<Integer> oddNumbers = numbers.parallelStream().filter(x -> x % 2 != 0).collect(Collectors.toSet());
System.out.println(oddNumbers); // [1, 3, 5]
```
#### Stream collect() to Map
We can use Collectors.toMap() function to collect the stream elements to a Map. This method accepts two arguments for mapping key and the corresponding value in the Map.
```
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
Map<Integer, String> mapOddNumbers = numbers.parallelStream().filter(x -> x % 2 != 0)
.collect(Collectors.toMap(Function.identity(), x -> String.valueOf(x)));
System.out.println(mapOddNumbers); // {1=1, 3=3, 5=5}
```
#### Collectors joining() Example
We can use Collectors joining() methods to get a Collector that concatenates the input stream CharSequence elements in the encounter order. We can use this to concatenate a stream of strings, StringBuffer, or StringBuilder.
```
String value = Stream.of("a", "b", "c").collect(Collectors.joining());
value ==> "abc"
String valueCSV = Stream.of("a", "b", "c").collect(Collectors.joining(","));
valueCSV ==> "a,b,c"
String valueCSVLikeArray = Stream.of("a", "b", "c").collect(Collectors.joining(",", "{", "}"));
valueCSVLikeArray ==> "{a,b,c}"
String valueObject = Stream.of("1", new StringBuffer("2"), new StringBuilder("3")).collect(Collectors.joining());
valueObject ==> "123"
```
Output
```
value : abc
valueCSV : a,b,c
valueCSVLikeArray : {a,b,c}
valueObject : 123
```

#### Java 8 Determining maximum and minimum with Collectors
We will use the predefined Collectors returned by `java.util.Stream.Collectors` class `maxBy()` and `minBy()` methods to find the maximum and minimum element of a given Stream. 

Collectors.maxBy()/minBy() methods are defined with the following signatures –
```
public static <T> Collector<T, ?, Optional<T>> maxBy(Comparator<? super T> comparator)

public static <T> Collector<T, ?, Optional<T>> minBy(Comparator<? super T> comparator)
```
* input parameter is an instance of Comparator of type T
* output is a Collector, acting on a Stream of elements of type T, with its finisher returning the maximum(for maxBy()) or minimum(for minBy()) value from all the elements of the stream as an Optional value

The predefined collectors returned by Collectors class’ maxBy()/minBy() methods get the maximum/minimum elements in the stream on which they are invoked using the `Stream.collect()` method. The max/min value is returned as an Optional value. This is because in case the stream has no elements then to avoid sending a bare null value which can result in a `NullPointerException`, the value is sent as an Optional.

Collectors.maxBy()/minBy() methods are terminal operations.

Internally, these collectors delegate their tasks to the ‘reducing collector’ with the calls reducing(BinaryOperator. maxBy(comparator)) and reducing(BinaryOperator. minBy(comparator)) for maximum/minimum element determination respectively. (Note that these calls to the reducing collector are internal to the implementation of the Collectors class, and need not be a point of consideration for the end programmer using these methods.)

