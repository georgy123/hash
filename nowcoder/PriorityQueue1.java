package nowcoder;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueue1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int size = in.nextInt();
			int[] x = new int[size];
			int[] y = new int[size];
			for (int i = 0; i < size; i++) {
				x[i] = in.nextInt();
			}
			for (int i = 0; i < size; i++) {
				y[i] = in.nextInt();
			}
			int[] res = minOPs(size, x, y);
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < size; i++) {
				result.append(String.valueOf(res[i]) + " ");
			}
			System.out.println(result.toString().trim());
		}
		in.close();
	}

	public static int[] minOPs(int size, int[] x, int[] y) {
		int[] res = new int[size];
		for (int i = 0; i < size; i++) {
			res[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					pq.add(Math.abs(x[k] - x[i]) + Math.abs(y[k] - y[j]));
				}
				int resI = 0;
				int sum = 0;
				while (!pq.isEmpty()) {
					sum += pq.poll();
					res[resI] = Math.min(res[resI], sum);
					resI++;
				}
			}
		}
		return res;
	}

}
