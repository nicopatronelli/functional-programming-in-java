package currying.first_iteration;

import java.util.function.BiFunction;
import java.util.function.Function;

import lombok.Getter;
import lombok.experimental.Accessors;

// Based on https://www.baeldung.com/java-currying

@Getter
@Accessors(fluent = true)
@SuppressWarnings({"java:S1117", "java:S1612", "java:S4276"})
public class Pokemon {
	private final Integer number;
	private final String name;

	public static final BiFunction<Integer, String, Pokemon> BUILDER
			= (number, name) -> new Pokemon(number, name);

	public static final Function<Integer, Function<String, Pokemon>> BUILDER_2
			= number -> (name -> new Pokemon(number, name));

	private Pokemon(Integer number, String name) {
		this.number = number;
		this.name = name;
	}
}
