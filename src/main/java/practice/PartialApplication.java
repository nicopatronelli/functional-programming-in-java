package practice;

import java.util.function.BiFunction;
import java.util.function.Function;

@SuppressWarnings({"squid:S4276", "squid:S106"})
public class PartialApplication {
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;
		Function<Integer, Integer> sumFiveTo = partial(sum, 5);
		final Integer result = sumFiveTo.apply(2); // 7
		System.out.println("The result is " + result);

//
		Function<Integer, Integer> sumFourTo = y -> sum.apply(4, y);
		final Integer result2 = sumFourTo.apply(8);
		System.out.println("The result 2 is " + result2);
	}

	public static <T, U, R> Function<U, R> partial(BiFunction<T, U, R> functionWithTwoParams, T x) {
		return y -> functionWithTwoParams.apply(x, y);
	}
}
