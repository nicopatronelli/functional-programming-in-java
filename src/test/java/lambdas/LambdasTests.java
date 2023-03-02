package lambdas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static util.Printer.print;

@SuppressWarnings("ALL")
public class LambdasTests {
//  REQ 1) A partir de una lista de números enteros, retornar una lista conteniendo el
//  doble de los pares
    private static List<Integer> dobleDePares(List<Integer> nums) {
        List<Integer> resultado = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);
            if (num % 2 == 0) {
                resultado.add(num * 2);
            }
        }
        return resultado;
    }

    @Test
    void testDobleDePares() {
        List<Integer> nums = dobleDePares(List.of(2, 3, 5, 6, 8, 9, 12));

        print(nums);

        assertEquals(4, nums.size());
        assertTrue(nums.contains(4));
        assertTrue(nums.contains(12));
        assertTrue(nums.contains(16));
        assertTrue(nums.contains(24));
    }

//  REQ 2) A partir de una lista de números enteros, retornar una lista conteniendo el
//  triple de los pares
    private static List<Integer> tripleDePares(List<Integer> nums) {
        List<Integer> resultado = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);
            if (num % 2 == 0) {
                resultado.add(num * 3);
            }
        }
        return resultado;
    }

    @Test
    void testTripleDePares() {
        List<Integer> nums = tripleDePares(List.of(2, 3, 5, 6, 8, 9, 12));

        print(nums);

        assertEquals(4, nums.size());
        assertTrue(nums.contains(6));
        assertTrue(nums.contains(18));
        assertTrue(nums.contains(24));
        assertTrue(nums.contains(36));
    }

//  1era iteración: Buscamos eliminar el código repetido a través de una primera abstracción
    private static List<Integer> paresMultiplicadosPor(List<Integer> nums, int factor) {
        List<Integer> resultado = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);
            if (num % 2 == 0) {
                resultado.add(num * factor);
            }
        }
        return resultado;
    }

// List<Integer> nums = paresMultiplicadosPor(List.of(2, 3, 5, 6, 8, 9, 12), 2);
// List<Integer> nums = paresMultiplicadosPor(List.of(2, 3, 5, 6, 8, 9, 12), 3);

//  REQ 3) A partir de una lista de números enteros, retornar una lista conteniendo los
//  impares restados por 3
    private static List<Integer> imparesMenosTres(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            Integer currentNum = nums.get(i);
            if (currentNum % 2 != 0) {
                result.add(currentNum - 3);
            }
        }
        return result;
    }

    @Test
    void testImparesMenosTres() {
        List<Integer> nums = imparesMenosTres(List.of(2, 3, 5, 6, 8, 9, 12));

        print(nums);

        assertEquals(3, nums.size());
        assertTrue(nums.contains(0));
        assertTrue(nums.contains(2));
        assertTrue(nums.contains(6));
    }

//    List<Integer> nums = aRenombrar(List.of(2, 3, 5, 6, 8, 9, 12),
//            new Condicion() {
//                @Override
//                public boolean test(int num) {
//                    return num % 2 != 0;
//                }
//            }, new Mapper() {
//                @Override
//                public int apply(int num) {
//                    return num - 3;
//                }
//            });

//  2da iteración: Nuestra primera abstracción ya no nos alcanza.
//  Creamos una nueva abstracción parametrizando "bloques" mediante clases anónimas (Java 7 o inferior)
    private static List<Integer> filtrarYMapear(List<Integer> nums, Condicion<Integer> condicion, Mapper<Integer, Integer> mapper) {
        List<Integer> resultado = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);
            if (condicion.test(num)) {
                resultado.add(mapper.apply(num));
            }
        }
        return resultado;
    }

//  REQ 4) Dada una lista con nombres de pokemons (strings), obtener una lista en mayúsculas de aquellos
//  que terminan con "chu".
    private static List<String> pokeNames(List<String> pokemonNames) {
        List<String> endsWithChu = new ArrayList<>();
        for (int i = 0; i < pokemonNames.size(); i++) {
            String currentName = pokemonNames.get(i);
            if (currentName.endsWith("chu")) {
                endsWithChu.add(currentName.toUpperCase());
            }
        }
        return endsWithChu;
    }

    @Test
    void testPokeNames() {
//        List<String> pokes = pokeNames(List.of("pikachu", "charmander", "squartle", "raichu", "snorlax"));
        List<String> pokes = filtrarYMapear2(List.of("pikachu", "charmander", "squartle", "raichu", "snorlax"),
                new Condicion<String>() {
                    @Override
                    public boolean test(String name) {
                        return name.endsWith("chu");
                    }
                },
                new Mapper<String, String>() {
                    @Override
                    public String apply(String name) {
                        return name.toUpperCase();
                    }
                });

        assertEquals(2, pokes.size());
        assertTrue(pokes.contains("PIKACHU"));
        assertTrue(pokes.contains("RAICHU"));
    }

//  4ta iteración:
//  Usamos generics para parametrizar los tipos de las interfaces y poder generalizar
//  nuestra solución
    private static <T> List<T> filtrarYMapear2(List<T> nums, Condicion<T> condition, Mapper<T,T>mapper) {
        List<T> resultado = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            T objetoActual = nums.get(i);
            if (condition.test(objetoActual)) {
                resultado.add(mapper.apply(objetoActual));
            }
        }
        return resultado;
    }

    //  Refactor con lambdas
    private static List<Integer> dobleDeParesConLambdas(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num * 2)
                .collect(toList());
    }

    private static List<Integer> imparesMenosTresConLambdas(List<Integer> nums) {
        return nums.stream()
            .filter(num -> num % 2 != 0)
            .map(num -> num - 3)
            .collect(toList());
    }

    private static List<String> pokemonsConLambdas(List<String> pokemonNames) {
        return pokemonNames.stream()
                .filter(name -> name.endsWith("chu"))
                .map(name -> name.toUpperCase())
                .collect(toList());
    }
}
