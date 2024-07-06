package com.javawiz.date_time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class LocalDateTimeToZFormat {

    public static void main(String[] args) {
        // Create a LocalDateTime object
        LocalDateTime localDateTime = LocalDateTime.now();

        // Create a DateTimeFormatter object with the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

        // Format the LocalDateTime object to a String in Z format
        String zFormattedDateTime = localDateTime.format(formatter);

        // Print the Z formatted date and time
        System.out.println(zFormattedDateTime);

        System.out.println();

        List<Book> books = Arrays.asList(new Book(1, "dasda"), new Book(3, "dqweqw"));
        Integer i = books.stream().sorted().findFirst()
            .map(Book::getId)
            .orElse(0);
        System.out.println(i);
    }
}

@AllArgsConstructor
@Getter
@Setter
class Book implements Comparable<Book>
{
    int id;
    String name;

    @Override
    public int compareTo(Book o) {
        return this.id - o.id;
    }
}