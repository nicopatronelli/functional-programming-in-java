package currying;

import org.junit.jupiter.api.Test;

import currying.first_iteration.Pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstIterationTests {
	@Test
	void test_builder_using_bifunction() {
		final Pokemon pikachu = Pokemon.BUILDER
				.apply(25, "pikachu");

		assertEquals(25, pikachu.number());
		assertEquals("pikachu", pikachu.name());
	}

	@Test
	void test_builder_using_function_currying_instead_of_a_bifunction() {
		final Pokemon pikachu = Pokemon.BUILDER_2
				.apply(25)
				.apply("pikachu");

		assertEquals(25, pikachu.number());
		assertEquals("pikachu", pikachu.name());
	}
}
