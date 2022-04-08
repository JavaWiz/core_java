### Java Stream reduce method
Java Stream is a sequence of elements from a source that supports aggregate operations. Streams do not store elements; the elements are computed on demand. Elements are consumed from data sources such as collections, arrays, or I/O resources.

A reduction is a terminal operation that aggregates a stream into a type or a primitive. The Java 8 Stream API contains a set of predefined reduction operations, such as average(), sum(), min(), max(), and count(), which return one value by combining the elements of a stream.

Stream.reduce() is a general-purpose method for generating our custom reduction operations.
```
Optional<T> reduce(BinaryOperator<T> accumulator)
```

This method performs a reduction on the elements of this stream, using an associative accumulation function. It returns an Optional describing the reduced value, if any.

```
T reduce(T identity, BinaryOperator<T> accumulator)
```
This method takes two parameters: the identity and the accumulator. The identity element is both the initial value of the reduction and the default result if there are no elements in the stream. The accumulator function takes two parameters: a partial result of the reduction and the next element of the stream. It returns a new partial result. The Stream.reduce() method returns the result of the reduction.

### Java Stream built-in reductions
The following example uses two predefined reduction operations.
```
import java.util.Arrays;

public class JavaReduceEx {

    public static void main(String[] args) {
        
        int values[] = { 2, 4, 6, 8, 10, 12, 14, 16 };
        
        int sum = Arrays.stream(values).sum();
        System.out.printf("The sum of values: %d%n", sum);
        
        long n = Arrays.stream(values).count();
        System.out.printf("The number of values: %d%n", n);        
    }
}
```
We have an array of integers. We create a stream from the array with Arrays.stream() and perform two reductions: sum() and count().
```
The sum of values: 72
The number of values: 8
```
### Java reduce Optional
The reduce() method with one parameter returns an Optional, which is a Java class for null safety.

The example creates a list of car objects. We compute the most expensive car.
```
Optional<Car> car = persons.stream().reduce((c1, c2) -> c1.getPrice() > c2.getPrice() ? c1 : c2);
```
From the list, we create a stream; the accumulator of the reduce() method compares the prices of the cars and returns the more expensive one.
```
car.ifPresent(System.out::println);
```

If the returned reduction value is not null, we print it to the console.
```
Car{name=Fiat, price=23650}
```
This is the output.

The next example adds other use cases.
```
public class MyUtil {

    public static int add2Ints(int num1, int num2) {
        return num1 + num2;
    }
}
```
This is MyUtil class having a method that adds two integers.
```
import java.util.stream.IntStream;

public class JavaReduceEx3 {

    public static void main(String[] args) {

        IntStream.range(1, 10).reduce((x, y) -> x + y)
                .ifPresent(s -> System.out.println(s));
        IntStream.range(1, 10).reduce(Integer::sum)
                .ifPresent(s -> System.out.println(s));
        IntStream.range(1, 10).reduce(MyUtil::add2Ints)
                .ifPresent(s -> System.out.println(s));
    }
}
```
We create three different accumulator functions to compute the sum of 1..10 values.
```
IntStream.range(1, 10).reduce((x, y) -> x + y).ifPresent(s -> System.out.println(s));
```
In the first case, we have a lambda expression doing the addition.
```
IntStream.range(1, 10).reduce(Integer::sum).ifPresent(s -> System.out.println(s));
```
The second case uses a built in Integer::sum method.
```
IntStream.range(1, 10).reduce(MyUtil::add2Ints).ifPresent(s -> System.out.println(s));
```
Finally, we have a custom addition method.

### Java reduce with identity
As we have already mentioned, the identity is both the initial value of the reduction and the default result if there are no elements in the stream.
```
import java.time.LocalDate;
import java.time.chrono.IsoChronology;

public class User {

    private String name;
    private LocalDate dateOfBirth;

    public User(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return dateOfBirth.until(IsoChronology.INSTANCE.dateNow())
                .getYears();
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("User{name=").append(name).append(", dateOfBirth=")
                .append(dateOfBirth).append("}");

        return builder.toString();
    }
}
```
This is the User class. In addition to the usual attributes and getters and setters, we have the getAge() method that returns the age of the user using Java 8 date API.
```
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JavaReduceEx4 {
    
    public static void main(String[] args) {
        
        List<User> users = new ArrayList<>();
        users.add(new User("Frank", LocalDate.of(1979, 11, 23)));
        users.add(new User("Peter", LocalDate.of(1985, 1, 18)));
        users.add(new User("Lucy", LocalDate.of(2002, 5, 14)));
        users.add(new User("Albert", LocalDate.of(1996, 8, 30)));
        users.add(new User("Frank", LocalDate.of(1967, 10, 6)));
        
        int maxAge = users.stream().mapToInt(User::getAge)
                .reduce(0, (a1, a2) -> a1 > a2 ? a1 : a2);
        
        System.out.printf("The oldest user's age: %s%n", maxAge);
    }
}
```
In the example, we create a list of users. The example calculates the age of the oldest user.
```
int maxAge = users.stream().mapToInt(User::getAge)
.reduce(0, (a1, a2) -> a1 > a2 ? a1 : a2);
```

From the list we create a Java 8 stream. The stream is mapped to an IntStream with a mapToInt() method. Finally, the reduce() method provides an identity value (0) and an accumulator; the accumulator compares the age values and returns the bigger one.






