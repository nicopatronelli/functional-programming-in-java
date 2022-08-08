package currying;

import org.junit.jupiter.api.Test;

import currying.third_iteration.Pokemon;
import currying.second_iteration.PokemonType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThirdIterationTests {
	@Test
	void test_builder_using_function_currying_with_prefilled_attributes() {
		final Pokemon pikachu = Pokemon.builder()
				.withNumber(25)
				.withName("pikachu")
				.withType(PokemonType.ELECTRIC)
				.withEvolution("raichu");

		assertEquals(25, pikachu.number());
		assertEquals("pikachu", pikachu.name());
		assertEquals(PokemonType.ELECTRIC, pikachu.type());
		assertEquals("raichu", pikachu.evolution());
	}
}
