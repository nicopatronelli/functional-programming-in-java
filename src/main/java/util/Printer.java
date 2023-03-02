package util;

import java.util.Iterator;

public class Printer {
    public static <T> void print(Iterable<T> list) {
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
/*
        list.forEach(System.out::println);
 */
    }
}
