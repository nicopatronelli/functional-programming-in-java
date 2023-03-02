package torename;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Composition {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> multiplyBy = (num, factor) -> num * factor;
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        Function<Integer, Integer> multiplyByTwoR = x -> multiplyBy.apply(x, 2);

    }
}
