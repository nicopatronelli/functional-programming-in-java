package lambdas;

import java.util.ArrayList;
import java.util.List;

public class LambdasExercises {

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
