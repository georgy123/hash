package nowcoder;

import java.util.Stack;

/**
 * 给你一段区间，需要你求出在这段区间之类的最小值*这段区间所有元素之和的最大值......
例如：
6
3 1 6 4 5 2
以4为最小值，向左右延伸，6 4 5  值为60
 * 
 *单调栈
 *@author {wqz}
 *
 * @date 2017年9月7日 上午11:54:41
 */
public class MaxInterval {
	public static int max2(int[] arr) {
		int size = arr.length;
		int[] sums = new int[size];
		sums[0] = arr[0];
		for (int i = 1; i < size; i++) {
			sums[i] = sums[i - 1] + arr[i];
		}
		int max = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < size; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				int j = stack.pop();
				max = Math.max(max, (stack.isEmpty() ? sums[i - 1] : (sums[i - 1] - sums[stack.peek()])) * arr[j]);
				System.out.print("stack:"+stack);
				System.out.println();
				System.out.print("i:"+i+","+"j:"+j+","+"max:"+max);
				System.out.println();
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int j = stack.pop();
			max = Math.max(max, (stack.isEmpty() ? sums[size - 1] : (sums[size - 1] - sums[stack.peek()])) * arr[j]);
			System.out.println();
			System.out.print("j:"+j+"max:"+max);
		}
		return max;
	}
	public static void main(String[] args) {
		int[] a ={3,1,6,4,5,2};
		System.out.println(MaxInterval.max2(a));
	}
}
