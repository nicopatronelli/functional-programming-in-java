package lambdas.req4;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static util.Printer.print;

public class ImparesMenosTres {
	//  A partir de una lista de números enteros, retornar una lista conteniendo los
	//  impares restados por 3
	private static List<Integer> imparesMenosTres(List<Integer> nums) {
		return null;
	}

	@Test
	void testImparesMenosTres() {
		List<Integer> nums = imparesMenosTres(List.of(2, 3, 5, 6, 8, 9, 12));

		print(nums);

		assertNotNull(nums);
		assertEquals(3, nums.size());
		assertTrue(nums.contains(0));
		assertTrue(nums.contains(2));
		assertTrue(nums.contains(6));
	}
}
