### The Stream.collect() Method
Stream.collect() is one of the Java 8's Stream API‘s terminal methods. It allows us to perform mutable fold operations (repackaging elements to some data structures and applying some additional logic, concatenating them, etc.) on data elements held in a Stream instance.

The strategy for this operation is provided via the Collector interface implementation.

### Collectors
All predefined implementations can be found in the `Collectors` class. It's common practice to use the following static import with them to leverage increased readability:
```
import static java.util.stream.Collectors.*;
```
We can also use single import collectors of our choice:

```
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
```
In the following examples, we'll be reusing the following list:
```
List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
```
### Collectors.toList()
The `toList` collector can be used for collecting all Stream elements into a List instance. The important thing to remember is that we can't assume any particular List implementation with this method. If we want to have more control over this, we can use toCollection instead.

Let's create a Stream instance representing a sequence of elements, and then collect them into a List instance:
```
List<String> result = givenList.stream()
.collect(toList());
```
### Collectors.toUnmodifiableList()
Java 10 introduced a convenient way to accumulate the Stream elements into an unmodifiable List:
```
List<String> result = givenList.stream().collect(toUnmodifiableList());
```
Now if we try to modify the result List, we'll get an UnsupportedOperationException:
```
assertThatThrownBy(() -> result.add("foo"))
.isInstanceOf(UnsupportedOperationException.class);
```
### Collectors.toSet()
The `toSet` collector can be used for collecting all Stream elements into a Set instance. The important thing to remember is that we can't assume any particular Set implementation with this method. If we want to have more control over this, we can use `toCollection` instead.

Let's create a Stream instance representing a sequence of elements, and then collect them into a Set instance:
```
Set<String> result = givenList.stream()
.collect(toSet());
```
A Set doesn't contain duplicate elements. If our collection contains elements equal to each other, they appear in the resulting Set only once:
```
List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
Set<String> result = listWithDuplicates.stream().collect(toSet());
assertThat(result).hasSize(4);
```
### Collectors.toUnmodifiableSet()
Since Java 10, we can easily create an unmodifiable Set using the toUnmodifiableSet() collector:
```
Set<String> result = givenList.stream()
.collect(toUnmodifiableSet());
```
Any attempt to modify the result Set will end up with an UnsupportedOperationException:
```
assertThatThrownBy(() -> result.add("foo"))
.isInstanceOf(UnsupportedOperationException.class);
```
### Collectors.toCollection()
As we've already noted, when using the toSet and toList collectors, we can't make any assumptions of their implementations. If we want to use a custom implementation, we'll need to use the toCollection collector with a provided collection of our choice.

Let's create a Stream instance representing a sequence of elements, and then collect them into a LinkedList instance:
```
List<String> result = givenList.stream()
.collect(toCollection(LinkedList::new))
```
Notice that this will not work with any immutable collections. In such a case, we would need to either write a custom Collector implementation or use `collectingAndThen`.
### Collectors.toMap()
The toMap collector can be used to collect Stream elements into a Map instance. To do this, we need to provide two functions:
```
keyMapper
valueMapper
```
We'll use keyMapper to extract a Map key from a Stream element, and valueMapper to extract a value associated with a given key.

Let's collect those elements into a Map that stores strings as keys and their lengths as values:
```
Map<String, Integer> result = givenList.stream()
.collect(toMap(Function.identity(), String::length))
```
`Function.identity()` is just a shortcut for defining a function that accepts and returns the same value.

So what happens if our collection contains duplicate elements? Contrary to `toSet`, `toMap` doesn't silently filter duplicates, which is understandable because how would it figure out which value to pick for this key?
```
List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
assertThatThrownBy(() -> {
listWithDuplicates.stream().collect(toMap(Function.identity(), String::length));
}).isInstanceOf(IllegalStateException.class);
```
Note that toMap doesn't even evaluate whether the values are also equal. If it sees duplicate keys, it immediately throws an `IllegalStateException`.

In such cases with key collision, we should use `toMap` with another signature:
```
Map<String, Integer> result = givenList.stream()
.collect(toMap(Function.identity(), String::length, (item, identicalItem) -> item));
```
The third argument here is a `BinaryOperator`, where we can specify how we want collisions to be handled. In this case, we'll just pick any of these two colliding values because we know that the same strings will always have the same lengths too.

### Collectors.toUnmodifiableMap()
Similar to with Lists and Sets, Java 10 introduced an easy way to collect Stream elements into an unmodifiable Map:
```
Map<String, Integer> result = givenList.stream()
.collect(toMap(Function.identity(), String::length))
```
As we can see, if we try to put a new entry into a result Map, we'll get an `UnsupportedOperationException`:
```
assertThatThrownBy(() -> result.put("foo", 3))
.isInstanceOf(UnsupportedOperationException.class);
```
###  Collectors.collectingAndThen()
CollectingAndThen is a special collector that allows us to perform another action on a result straight after collecting ends.

Let's collect Stream elements to a List instance, and then convert the result into an ImmutableList instance:
```
List<String> result = givenList.stream()
.collect(collectingAndThen(toList(), ImmutableList::copyOf))
3.6. Collectors.joining()
```
Joining collector can be used for joining `Stream<String>` elements.

We can join them together by doing:
```
String result = givenList.stream().collect(joining());
```
This will result in:
```
abbcccdd
```
We can also specify custom separators, prefixes, postfixes:
```
String result = givenList.stream().collect(joining(" "));
```
This will result in:
```
a bb ccc dd
```
We can also write:
```
String result = givenList.stream().collect(joining(" ", "PRE-", "-POST"));
```
This will result in:
```
PRE-a bb ccc dd-POST
```
### Collectors.counting()
Counting is a simple collector that allows for the counting of all Stream elements.

Now we can write:
```
Long result = givenList.stream()
.collect(counting());
```
### Collectors.summarizingDouble/Long/Int()
SummarizingDouble/Long/Int is a collector that returns a special class containing statistical information about numerical data in a Stream of extracted elements.

We can obtain information about string lengths by doing:
```
DoubleSummaryStatistics result = givenList.stream()
.collect(summarizingDouble(String::length));
```
In this case, the following will be true:
```
assertThat(result.getAverage()).isEqualTo(2);
assertThat(result.getCount()).isEqualTo(4);
assertThat(result.getMax()).isEqualTo(3);
assertThat(result.getMin()).isEqualTo(1);
assertThat(result.getSum()).isEqualTo(8);
```
### Collectors.averagingDouble/Long/Int()
AveragingDouble/Long/Int is a collector that simply returns an average of extracted elements.

We can get the average string length by doing:
```
Double result = givenList.stream().collect(averagingDouble(String::length));
```
### Collectors.summingDouble/Long/Int()
SummingDouble/Long/Int is a collector that simply returns a sum of extracted elements.

We can get the sum of all string lengths by doing:
```
Double result = givenList.stream().collect(summingDouble(String::length));
```
### Collectors.maxBy()/minBy()
MaxBy/MinBy collectors return the biggest/smallest element of a Stream according to a provided Comparator instance.

We can pick the biggest element by doing:
```
Optional<String> result = givenList.stream().collect(maxBy(Comparator.naturalOrder()));
```
We can see that the returned value is wrapped in an Optional instance. This forces users to rethink the empty collection corner case.
### Collectors.groupingBy()
GroupingBy collector is used for grouping objects by some property, and then storing the results in a Map instance.

We can group them by string length, and store the grouping results in Set instances:
```
Map<Integer, Set<String>> result = givenList.stream()
.collect(groupingBy(String::length, toSet()));
```
This will result in the following being true:
```
assertThat(result)
.containsEntry(1, newHashSet("a"))
.containsEntry(2, newHashSet("bb", "dd"))
.containsEntry(3, newHashSet("ccc"));
```
We can see that the second argument of the `groupingBy` method is a Collector. In addition, we're free to use any Collector of our choice.

### Collectors.partitioningBy()
PartitioningBy is a specialized case of groupingBy that accepts a Predicate instance, and then collects Stream elements into a Map instance that stores Boolean values as keys and collections as values. Under the “true” key, we can find a collection of elements matching the given Predicate, and under the “false” key, we can find a collection of elements not matching the given Predicate.

We can write:
```
Map<Boolean, List<String>> result = givenList.stream().collect(partitioningBy(s -> s.length() > 2))
```
This results in a Map containing:
```
{false=["a", "bb", "dd"], true=["ccc"]}
```
### Collectors.teeing()
Let's find the maximum and minimum numbers from a given Stream using the collectors we've learned so far:
```
List<Integer> numbers = Arrays.asList(42, 4, 2, 24);
Optional<Integer> min = numbers.stream().collect(minBy(Integer::compareTo));
Optional<Integer> max = numbers.stream().collect(maxBy(Integer::compareTo));
// do something useful with min and max
```
Here we're using two different collectors, and then combining the results of those two to create something meaningful. Before Java 12, in order to cover such use cases, we had to operate on the given Stream twice, store the intermediate results into temporary variables, and then combine those results afterwards.

Fortunately, Java 12 offers a built-in collector that takes care of these steps on our behalf; all we have to do is provide the two collectors and the combiner function.

Since this new collector tees the given stream towards two different directions, it's called teeing:
```
numbers.stream().collect(teeing(
minBy(Integer::compareTo), // The first collector
maxBy(Integer::compareTo), // The second collector
(min, max) -> // Receives the result from those collectors and combines them
));
```
### Custom Collectors
If we want to write our own Collector implementation, we need to implement the Collector interface, and specify its three generic parameters:
```
public interface Collector<T, A, R> {...}
T – the type of objects that will be available for collection
A – the type of a mutable accumulator object
R – the type of a final result
```
Let's write an example Collector for collecting elements into an ImmutableSet instance. We start by specifying the right types:
```
private class ImmutableSetCollector<T>
implements Collector<T, ImmutableSet.Builder<T>, ImmutableSet<T>> {...}
```
Since we need a mutable collection for internal collection operation handling, we can't use ImmutableSet. Instead, we need to use some other mutable collection, or any other class that could temporarily accumulate objects for us. In this case, we will go with an ImmutableSet.Builder and now we need to implement 5 methods:
```
Supplier<ImmutableSet.Builder<T>> supplier()
BiConsumer<ImmutableSet.Builder<T>, T> accumulator()
BinaryOperator<ImmutableSet.Builder<T>> combiner()
Function<ImmutableSet.Builder<T>, ImmutableSet<T>> finisher()
Set<Characteristics> characteristics()
```
The supplier() method returns a Supplier instance that generates an empty accumulator instance. So in this case, we can simply write:
```
@Override
public Supplier<ImmutableSet.Builder<T>> supplier() {
   return ImmutableSet::builder;
}
```
The accumulator() method returns a function that is used for adding a new element to an existing accumulator object. So let's just use the Builder‘s add method:
```
@Override
public BiConsumer<ImmutableSet.Builder<T>, T> accumulator() {
return ImmutableSet.Builder::add;
}
```
The combiner() method returns a function that is used for merging two accumulators together:

@Override
public BinaryOperator<ImmutableSet.Builder<T>> combiner() {
return (left, right) -> left.addAll(right.build());
}
The finisher() method returns a function that is used for converting an accumulator to final result type. So in this case, we'll just use Builder‘s build method:

@Override
public Function<ImmutableSet.Builder<T>, ImmutableSet<T>> finisher() {
return ImmutableSet.Builder::build;
}
The characteristics() method is used to provide Stream with some additional information that will be used for internal optimizations. In this case, we don't pay attention to the elements order in a Set because we'll use Characteristics.UNORDERED. To obtain more information regarding this subject, check Characteristics‘ JavaDoc:

@Override public Set<Characteristics> characteristics() {
return Sets.immutableEnumSet(Characteristics.UNORDERED);
}
Here is the complete implementation along with the usage:

public class ImmutableSetCollector<T>
implements Collector<T, ImmutableSet.Builder<T>, ImmutableSet<T>> {

@Override
public Supplier<ImmutableSet.Builder<T>> supplier() {
return ImmutableSet::builder;
}

@Override
public BiConsumer<ImmutableSet.Builder<T>, T> accumulator() {
return ImmutableSet.Builder::add;
}

@Override
public BinaryOperator<ImmutableSet.Builder<T>> combiner() {
return (left, right) -> left.addAll(right.build());
}

@Override
public Function<ImmutableSet.Builder<T>, ImmutableSet<T>> finisher() {
return ImmutableSet.Builder::build;
}

@Override
public Set<Characteristics> characteristics() {
return Sets.immutableEnumSet(Characteristics.UNORDERED);
}

public static <T> ImmutableSetCollector<T> toImmutableSet() {
return new ImmutableSetCollector<>();
}
Finally, here in action:

List<String> givenList = Arrays.asList("a", "bb", "ccc", "dddd");

ImmutableSet<String> result = givenList.stream()
.collect(toImmutableSet());





































