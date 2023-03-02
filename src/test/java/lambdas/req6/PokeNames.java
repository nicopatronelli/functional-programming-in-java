package lambdas.req6;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PokeNames {
	//  Dada una lista con nombres de pokemons (strings), obtener una lista en mayúsculas de aquellos
	//  que terminan con "chu".
	private static List<String> pokeNames(List<String> pokemonNames) {
		return null;
	}

	@Test
	void testPokeNames() {
		List<String> pokes = pokeNames(List.of("pikachu", "charmander", "squartle", "raichu", "snorlax"));

		assertNotNull(pokes);
		assertEquals(2, pokes.size());
		assertTrue(pokes.contains("PIKACHU"));
		assertTrue(pokes.contains("RAICHU"));
	}
}
