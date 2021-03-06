## Java 8 Stream
Java provides a new additional package in Java 8 called `java.util.stream`. This package consists of classes, interfaces and enum to allows functional-style operations on the elements. You can use stream by importing `java.util.stream` package.

Stream provides following features:

* Stream does not store elements. It simply conveys elements from a source such as a data structure, an array, or an I/O channel, through a pipeline of computational operations.

* Stream is functional in nature. Operations performed on a stream does not modify it's source. For example, filtering a Stream obtained from a collection produces a new Stream without the filtered elements, rather than removing elements from the source collection.

* Stream is lazy and evaluates code only when required.

* The elements of a stream are only visited once during the life of a stream. Like an Iterator, a new stream must be generated to revisit the same elements of the source.
   
You can use stream to filter, collect, print, and convert from one data structure to other etc. In the following examples, we have apply various operations with the help of stream.

## Java Stream Interface Methods
```
boolean allMatch(Predicate<? super T> predicate)
```
Returns whether all elements of this stream match the provided predicate. May not evaluate the predicate on all elements if not necessary for determining the result. If the stream is empty then true is returned and the predicate is not evaluated.
This is a short-circuiting terminal operation.

```
boolean anyMatch(Predicate<? super T> predicate)
```
Returns whether any elements of this stream match the provided predicate. May not evaluate the predicate on all elements if not necessary for determining the result. If the stream is empty then false is returned and the predicate is not evaluated.
This is a short-circuiting terminal operation.
```
boolean noneMatch(Predicate<? super T> predicate)
```
Returns whether no elements of this stream match the provided predicate. May not evaluate the predicate on all elements if not necessary for determining the result. If the stream is empty then true is returned and the predicate is not evaluated.
This is a short-circuiting terminal operation.
```
static <T> Stream.Builder<T> builder()
```
It returns a builder for a Stream.

