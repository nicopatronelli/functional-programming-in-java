package highorderfunctions.req2;

import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Pokemon;

import static highorderfunctions.repository.PokemonRepository.charmander;
import static highorderfunctions.repository.PokemonRepository.charmeleon;
import static highorderfunctions.repository.PokemonRepository.pikachu;
import static highorderfunctions.repository.PokemonRepository.raichu;
import static highorderfunctions.repository.PokemonRepository.snorlax;
import static highorderfunctions.repository.PokemonRepository.squartle;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PokemonElectricoConEntrenadorYNivelMayorA15Test {
	//  EJERCICIO 2: Dada una lista de pokemons, indicar si alguno de ellos cumple con tener un level mayor a 15, ser de tipo eléctrico
	// y tener entrenador.
	public static boolean hayAlgunPokemonElectricoConEntrenadorDeNivelMayorA15(List<Pokemon> pokemons) {
		return false; // TODO: Implement it
	}

	//	public static boolean hayAlgunPokemonElectricoConEntrenadorDeNivelMayorA15(List<Pokemon> pokemons) {
	//		return pokemons.stream()
	//				.filter(pokemon -> pokemon.esDeTipo(PokemonType.ELECTRIC))
	//				.anyMatch(pokemon -> pokemon.tieneEntrenador() && pokemon.level() >= 15);
	//	}

	@Test
	public void testPokemonElectricoConEntrenadorMayorANivel15() {
		final List<Pokemon> pokemons = List.of(pikachu, raichu, charmander, charmeleon, squartle, snorlax);
		assertTrue(hayAlgunPokemonElectricoConEntrenadorDeNivelMayorA15(pokemons));
	}
}
