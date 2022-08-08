package currying;

import org.junit.jupiter.api.Test;

import currying.second_iteration.Pokemon;
import currying.second_iteration.PokemonType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondIterationTests {
	@Test
	void test_builder_using_function_currying_instead_of_a_bifunction() {
		final Pokemon pikachu = Pokemon.BUILDER_2
				.apply(25)
				.apply("pikachu")
				.apply(PokemonType.ELECTRIC)
				.apply("raichu");

		assertEquals(25, pikachu.number());
		assertEquals("pikachu", pikachu.name());
		assertEquals(PokemonType.ELECTRIC, pikachu.type());
		assertEquals("raichu", pikachu.evolution());
	}

	@Test
	void test_builder_using_function_currying_with_prefilled_attributes() {
		final Pokemon pikachu = Pokemon.BUILDER_ELECTRIC
				.apply(25)
				.apply("pikachu")
				.apply("raichu");

		assertEquals(25, pikachu.number());
		assertEquals("pikachu", pikachu.name());
		assertEquals(PokemonType.ELECTRIC, pikachu.type());
		assertEquals("raichu", pikachu.evolution());
	}
}
