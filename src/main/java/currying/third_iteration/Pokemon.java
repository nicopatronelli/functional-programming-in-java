package currying.third_iteration;

import java.util.function.Function;

import currying.second_iteration.PokemonType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter @Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings({"java:S1117", "java:S1612", "java:S4276"})
public class Pokemon {
	private final Integer number;
	private final String name;
	private final PokemonType type;
	private final String evolution; // could be another Pokemon

	public static WithNumber builder() {
		return (number)
				-> (name
				-> type
				-> evolution
				-> new Pokemon(number, name, type, evolution));
	}

	@FunctionalInterface
	public interface WithNumber {
		Pokemon.WithName withNumber(Integer number);
	}

	@FunctionalInterface
	public interface WithName {
		Pokemon.WithType withName(String name);
	}

	@FunctionalInterface
	public interface WithType {
		Pokemon.WithEvolution withType(PokemonType type);
	}

	@FunctionalInterface
	public interface WithEvolution {
		Pokemon withEvolution(String evolution);
	}
}