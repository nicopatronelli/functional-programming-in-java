package lambdas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

//  2da iteración: Nuestra segunda abstracción tampoco nos alcanza ahora.
//  Creamos un nuevo método estático parametrizando los dos bloques de código utilizados
    private static List<Integer> aRenombrar(List<Integer> nums, Condicion condicion, Mapper mapper) {
        List<Integer> resultado = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);
            if (condicion.test(num)) {
                resultado.add(mapper.aplicar(num));
            }
        }
        return resultado;
    }
}
