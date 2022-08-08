package currying.second_iteration;

import java.util.function.Function;

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

	public static final Function<Integer,
							Function<String,
									Function<PokemonType,
											Function<String, Pokemon>>>> BUILDER
			= number -> (name -> (type -> (evolution -> new Pokemon(number, name, type, evolution))));

	// Another way of write it BUILDER
	public static final Function<Integer,
			Function<String,
					Function<PokemonType,
							Function<String, Pokemon>>>> BUILDER_2
			= number
				-> name
				-> type
				-> evolution
				-> new Pokemon(number, name, type, evolution);

	public static final Function<Integer,
			Function<String,
							Function<String, Pokemon>>> BUILDER_ELECTRIC
			= number
			-> name
			-> evolution
			-> new Pokemon(number, name, PokemonType.ELECTRIC, evolution);
}
