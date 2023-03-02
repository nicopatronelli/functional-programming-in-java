package highorderfunctions.req3;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListaDeListasTest {
	// EJERCICIO 3: Dada una lista que contiene a su vez listas de números, imprimir
	// por pantalla cada número contenido en las listas sin repetidos y en orden natural.
	// Además, no se deben imprimir números negativos.
	public static void imprimirNumerosSinRepetidosySinNegativosEnOrden(List<List<Integer>> listOfLists) {
		// TODO: Implement it
	}

//	public static void imprimirNumerosSinRepetidosySinNegativosEnOrden(List<List<Integer>> listOfLists) {
//		listOfLists.stream()
//				.flatMap(list -> list.stream())
//				.filter(num -> num >= 0)
//				.sorted((numA, numB) -> numA - numB)
//				.collect(toSet())
//				.forEach(num -> System.out.println(num));
//	}

	@Test
	public void test() {
		imprimirNumerosSinRepetidosySinNegativosEnOrden(List.of(List.of(2,5,-1,3,3,10), List.of(4,1,-5,3,8,7), List.of(5,7,-2,-2,6,9,8,3,9)));
	}
}
