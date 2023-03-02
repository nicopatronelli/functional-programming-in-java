package lambdas.req1;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static util.Printer.print;

public class DobleDePares {
	//  A partir de una lista de números enteros, retornar una lista conteniendo el
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

		assertNotNull(nums);
		assertEquals(4, nums.size());
		assertTrue(nums.contains(4));
		assertTrue(nums.contains(12));
		assertTrue(nums.contains(16));
		assertTrue(nums.contains(24));
	}
}
