package immutability;

import currying.second_iteration.PokemonType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class ApiStreamImmutabilityExamples {

    public static void main(String[] args) {
//        principalExample();
        groupingByExample();
    }

    private static void principalExample() {
        List<Pokemon> pokes = Arrays.asList(
                Pokemon.of(25, "pikachu", PokemonType.ELECTRIC),
                Pokemon.of(4, "charmander", PokemonType.FIRE),
                Pokemon.of(5, "charmeleon", PokemonType.FIRE));

        List<Pokemon> pokesBeforeTen = pokes.stream()
                .filter(poke -> poke.number < 10)
                .collect(toList());

//        pokes.add(Pokemon.of(143, "snorlax")); // UnsupportedOperationException
        pokesBeforeTen.add(Pokemon.of(7, "squartle", PokemonType.WATER)); // works

//        Pokemon originalCharmander = pokes.get(1);
//        Pokemon filteredCharmander = pokesBeforeTen.get(0);

//        filteredCharmander.name("char char"); // mutates both
//        originalCharmander.name("char char"); // mutates both

        System.out.println("----");
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter @Setter @Accessors(fluent = true)
    static class Pokemon {
        private int number;
        private String name;
        private PokemonType type;

        public static Pokemon of(int number, String name, PokemonType type) {
            return new Pokemon(number, name, type);
        }
    }

    public static void groupingByExample() {
        List<Pokemon> pokes = Arrays.asList(
                Pokemon.of(25, "pikachu", PokemonType.ELECTRIC),
                Pokemon.of(26, "raichu", PokemonType.ELECTRIC),
                Pokemon.of(4, "charmander", PokemonType.FIRE),
                Pokemon.of(5, "charmeleon", PokemonType.FIRE));


        Map<Boolean, List<Pokemon>> map = pokes.stream()
                .collect(groupingBy(poke -> poke.type == PokemonType.ELECTRIC));

        System.out.println("----");
    }
}
