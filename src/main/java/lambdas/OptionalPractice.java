package lambdas;

import currying.second_iteration.PokemonType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.Optional;

import static java.util.Objects.nonNull;

public class OptionalPractice {
    public static void main(String[] args) {
//        optionalOf();
//        optionalOfNullable();
//        noSuchElementFromStreamApi();
//        withoutOptional();
//        withOptional();
        optionalEmpty();
    }

    private static void noSuchElementFromStreamApi() {
        Integer result = Arrays.asList(1, 2, 3).stream()
                .filter(num -> num > 5)
                .map(num -> num * 2)
                .findFirst()
                .get();
    }

    private static void optionalOf() {
        Optional<Object> opt1 = Optional.of(null); // NPE
        Object obj1 = opt1.get(); // Doesn't reach this line
    }

    private static void optionalOfNullable() {
        Optional<Object> opt2 = Optional.ofNullable(null); // OK
        Object obj2 = opt2.get(); // No SuchElementException
    }

    private static void optionalEmpty() {
//        Optional.of(Pokemon.of(25, "pikachu", PokemonType.ELECTRIC))
//                .filter(poke -> poke.type() == PokemonType.FIRE)
//                .map(poke -> poke.name())
//                .orElseGet()

        Optional<Pokemon> opt = Optional.empty();
        String optContent = opt.filter(poke -> poke.type() == PokemonType.FIRE)
                .map(poke -> poke.name())
                .orElseGet(() -> "pika pika");

        System.out.println(optContent);
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

    private static void withoutOptional() {
        Pokemon pikachu = Pokemon.of(25, "pikachu", PokemonType.ELECTRIC);
//      pikachu could be null (maybe comes from a remote server call)
        if (nonNull(pikachu)) {
            if (nonNull(pikachu.type()) && pikachu.type() == PokemonType.ELECTRIC) {
                if (nonNull(pikachu.number())) {
                    System.out.println("Pikachu number is :" + pikachu.number());
                }
            }
        }
    }

    private static void withOptional() {
        Pokemon pikachu = Pokemon.of(25, "pikachu", null);
//      pikachu could be null (maybe comes from a remote server call)
        Pokemon pikachuNull = null;
        Optional.ofNullable(pikachuNull)
                .filter(pika -> pika.type() == PokemonType.ELECTRIC)
                .map(pika -> pika.number())
                .ifPresent(number -> System.out.println("Pikachu number is :" + number));
    }
}
