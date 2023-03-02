package lambdas.req2;

import java.util.List;

import org.junit.jupiter.api.Test;

import static lambdas.req3.ParesMultiplicadosPor.paresMultiplicadosPor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static util.Printer.print;

public class TripleDePares {
	//  A partir de una lista de números enteros, retornar una lista conteniendo el
	//  triple de los pares
	private static List<Integer> tripleDePares(List<Integer> nums) {
		return null;
	}

	@Test
	void testTripleDePares() {
		List<Integer> nums = tripleDePares(List.of(2, 3, 5, 6, 8, 9, 12));

		print(nums);

		assertNotNull(nums);
		assertEquals(4, nums.size());
		assertTrue(nums.contains(6));
		assertTrue(nums.contains(18));
		assertTrue(nums.contains(24));
		assertTrue(nums.contains(36));
	}
}
