package Algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class NewTest {
	// ----------Two number summ-----------------

	// #1
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

	//#2
	public static int[] twoNumberSum2(int[] array, int targetSum) {
		Arrays.sort(array);
		int left=0;
		int right=array.length-1;
		while(left<right) {
			int diff=targetSum-array[right];
			if(diff<array[left]) {
				right--;
			}else if(diff==array[left]) {
				return new int[] {array[left],array[right]};
			}else {
				left++;
			}
		}
		return new int[0];
	}
	

	@Test
	public void f() {
		System.out.println(twoNumberSum2(new int[] { 3, 5, -4, 8, 11, 1, -1, 6 }, 10).length);
	}
}
