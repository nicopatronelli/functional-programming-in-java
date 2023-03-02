package util;

import java.util.List;

public class Printer {
    public static <T> void print(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }
}
