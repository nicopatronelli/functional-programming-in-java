package highorderfunctions.repository;

import domain.pokemon.Pokemon;
import domain.pokemon.PokemonType;

public class PokemonRepository {
	public static final Pokemon pikachu = buildPikachu();
	public static final Pokemon raichu = buildRaichu();
	public static final Pokemon charmander = buildCharmander();
	public static final Pokemon charmeleon = buildCharmeleon();
	public static final Pokemon squartle = buildSquartle();
	public static final Pokemon snorlax = buildSnorlax();

	private static Pokemon buildPikachu() {
		return Pokemon.builder()
					.number(25)
					.name("pikachu")
					.type(PokemonType.ELECTRIC)
					.esSalvaje(false)
					.level(15)
				.build();
	}

	private static Pokemon buildRaichu() {
		return Pokemon.builder()
					.number(26)
					.name("raichu")
					.type(PokemonType.ELECTRIC)
					.esSalvaje(false)
					.level(30)
				.build();
	}

	private static Pokemon buildCharmander() {
		return Pokemon.builder()
					.number(4)
					.name("charmander")
					.type(PokemonType.FIRE)
					.esSalvaje(false)
					.level(10)
				.build();
	}

	private static Pokemon buildCharmeleon() {
		return Pokemon.builder()
					.number(5)
					.name("charmeleon")
					.type(PokemonType.FIRE)
					.esSalvaje(true)
					.level(16)
				.build();
	}

	private static Pokemon buildSquartle() {
		return Pokemon.builder()
					.number(7)
					.name("squartle")
					.type(PokemonType.WATER)
					.esSalvaje(false)
					.level(12)
				.build();
	}

	private static Pokemon buildSnorlax() {
		return Pokemon.builder()
					.number(143)
					.name("snorlax")
					.type(PokemonType.NORMAL)
					.esSalvaje(false)
					.level(45)
				.build();
	}
}
