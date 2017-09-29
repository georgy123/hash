package algorithms.test;

import algorithms.MaxSum;

public class MaxSumTest {
     
	public static void main(String[] args) {
		int[] a = {-2,11,-4,13,-5,-2};
		//int maxSum = MaxSum.maxSumByDp(a);
		int sumDiv = MaxSum.MaxSumDiv(a, 0, a.length-1);
		System.out.println("最大字段和为："+sumDiv);
	}
}
