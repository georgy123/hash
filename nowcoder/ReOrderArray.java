package nowcoder;

import java.util.ArrayList;

public class ReOrderArray {
	public void reOrderArray(int[] array) {
		ArrayList<Integer> odd = new ArrayList<Integer>();
		ArrayList<Integer> even = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & 1) == 1) {
				odd.add(array[i]);
			} else {
				even.add(array[i]);
			}
		}
		odd.addAll(even);
		for (int i = 0; i < array.length; i++) {
			array[i] = odd.get(i);
		}
	}
	public void reOrderArray2(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j - 1] % 2 == 0 && array[j] % 2 == 1) {
					int temp = 0;
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	// 类似冒泡算法，前偶后奇数就交换
	public void reOrderArray3(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
					int t = array[j];
					array[j] = array[j + 1];
					array[j + 1] = t;
				}
			}
		}
	}
}
