package Algoexpert.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class NewTest {
	// ----------Two number summ-----------------
	public static int[] twoNumberSum(int[] array, int targetSum) {
		Set<Integer> set = new HashSet<>();
		for (int i : array) {
			int summ = targetSum - i;
			if (set.contains(summ)) {
				return new int[] { i, summ };
			} else {
				set.add(i);
			}
			
		}
		return new int[0];
	}

	@Test
	public void f() {
		System.out.println(twoNumberSum(new int[] { 3, 5, -4, 8, 11, 1, -1, 6 }, 10).length);
	}
}
