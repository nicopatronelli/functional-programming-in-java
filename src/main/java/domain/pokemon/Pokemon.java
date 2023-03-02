package domain.pokemon;

public class Pokemon {
	private int number;
	private int level;
	private String name;
	private PokemonType type;
	private boolean esSalvaje;

	public Pokemon(int number, int level, String name, PokemonType type, boolean esSalvaje) {
		this.number = number;
		this.level = level;
		this.name = name;
		this.type = type;
		this.esSalvaje = esSalvaje;
	}

	public int number() {
		return this.number;
	}

	public int level() {
		return this.level;
	}

	public String name() {
		return this.name;
	}

	public boolean tieneEntrenador() {
		return !this.esSalvaje;
	}

	public boolean esSalvaje(boolean value) {
		return this.esSalvaje = value;
	}

	public boolean esDeTipo(PokemonType typeToCheck) {
		return this.type == typeToCheck;
	}

	public static PokemonBuilder builder() {
		return new PokemonBuilder();
	}

	public static class PokemonBuilder {
		private int number;
		private int level;
		private String name;
		private PokemonType type;
		private boolean esSalvaje;

		public PokemonBuilder number(int number) {
			this.number = number;
			return this;
		}

		public PokemonBuilder level(int level) {
			this.level = level;
			return this;
		}

		public PokemonBuilder name(String name) {
			this.name = name;
			return this;
		}

		public PokemonBuilder type(PokemonType type) {
			this.type = type;
			return this;
		}

		public PokemonBuilder esSalvaje(boolean esSalvaje) {
			this.esSalvaje = esSalvaje;
			return this;
		}

		public Pokemon build() {
			return new Pokemon(
					this.number,
					this.level,
					this.name,
					this.type,
					this.esSalvaje
			);
		}

	}

}
