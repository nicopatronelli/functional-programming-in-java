package highorderfunctions.req1;

import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Pokemon;
import domain.PokemonType;

import static highorderfunctions.repository.PokemonRepository.charmander;
import static highorderfunctions.repository.PokemonRepository.charmeleon;
import static highorderfunctions.repository.PokemonRepository.pikachu;
import static highorderfunctions.repository.PokemonRepository.raichu;
import static highorderfunctions.repository.PokemonRepository.snorlax;
import static highorderfunctions.repository.PokemonRepository.squartle;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumaDeNivelesTest {
	//  EJERCICIO 1: A partir de una lista de pokemons, retornar la sumatoria del nivel
	//	de aquellos que sean de tipo eléctrico y que pertenezcan a un entrenador (no son salvajes)
	public static int sumarNivelDePokemonsQueNoSeanDeAguaYTenganEntrenador(List<Pokemon> pokemons) {
		int totalLevel = 0;
		for (Pokemon pokemon : pokemons) {
			if (!pokemon.esDeTipo(PokemonType.WATER)) {
				if (pokemon.tieneEntrenador()) {
					int level = pokemon.level();
					totalLevel += level;
				}
			}
		}
		return totalLevel;
	}

	//	TODO: Reescribir usando la API de Stream
	//	public static int sumarNivelDePokemonsQueNoSeanDeAguaYTenganEntrenador(List<Pokemon> pokemons) {
	//		return pokemons.stream()
	//				.filter(pokemon -> !pokemon.esDeTipo(PokemonType.WATER))
	//				.filter(pokemon -> pokemon.tieneEntrenador()) // Method reference
	//				.map(pokemon -> pokemon.level())
	//				.reduce(0, (numA, numB) -> numA + numB);
	//	}

	@Test
	public void testSumaDeNiveles() {
		final List<Pokemon> pokemons = List.of(pikachu, raichu, charmander, charmeleon, squartle, snorlax);
		final int totalLevel = sumarNivelDePokemonsQueNoSeanDeAguaYTenganEntrenador(pokemons);
		assertEquals(100, totalLevel);
	}

}
