package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 打印回环数字矩阵，输入参数为边长n，例如n=4，求如下的回环矩阵：
 * 
 * 1 2 3 4 12 13 14 5 11 16 15 6 10 9 8 7 问题的本质其实就是打印一个方形。每一个方形代表矩阵的每一层。
 *
 * @author {wqz}
 *
 * @date 2017年9月3日 上午11:15:05
 */
public class SnackArray {
	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (matrix.length == 0)
			return null;
		int row = matrix.length;
		int col = matrix[0].length;
		int left = 0, right = col - 1, top = 0, bottom = row - 1;
		while (left <= right && top <= bottom) {
			// 从左至右
			for (int i = left; i <= right; i++) {
				list.add(matrix[top][i]);
			}
			// 从上到下
			for (int i = top + 1; i <= bottom; i++) {
				list.add(matrix[i][right]);
			}
			// 从右到左
			if (top != bottom) {
				for (int i = right - 1; i >= left; i--) {
					list.add(matrix[bottom][i]);
				}
			}
			// 从下到上
			if (left != right) {
				for (int i = bottom - 1; i > top; i--) {
					list.add(matrix[i][left]);
				}
			}
			left++;
			top++;
			right--;
			bottom--;
		}
		return list;
	}
   /**
    * 逆时针回旋矩阵
    * @param n
    * @return
    */
	public static int[][] loopMatrix(int n) {
		int[][] matrix = new int[n][n];
		for (int num = 1, x = 0, y = 0, xDir = 1, yDir = 0; num <= n * n; num++) {
			matrix[x][y] = num;
			if (x + xDir < 0 || y + yDir < 0 || x + xDir == n || y + yDir == n || matrix[x + xDir][y + yDir] != 0) {// 如果到边界了就换方向
				if (xDir != 0) {
					yDir = xDir;
					xDir = 0;
				} else {
					xDir = -yDir;
					yDir = 0;
				}
			}
			x += xDir;
			y += yDir;
		}
		return matrix;
	}

	public static int[][] loopMatrix2(int n) {
		int[][] matrix = new int[n][n];
		int row = matrix.length;
		int col = matrix[0].length;
		int left = 0, right = col - 1, top = 0, bottom = row - 1;
		int num=1;
		while (left <= right && top <= bottom) {
			// 从左至右
			for (int i = left; i <= right; i++) {
				matrix[top][i]=num++;
			}
			// 从上到下
			for (int i = top + 1; i <= bottom; i++) {
                matrix[i][right]=num++;
			}
			// 从右到左
			if (top != bottom) {
				for (int i = right - 1; i >= left; i--) {
					matrix[bottom][i]=num++;
				}
			}
			// 从下到上
			if (left != right) {
				for (int i = bottom - 1; i > top; i--) {
					matrix[i][left]=num++;
				}
			}
			left++;
			top++;
			right--;
			bottom--;
		}
		return matrix;
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 } };
		ArrayList<Integer> list = SnackArray.printMatrix(a);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ",");
			if ((i + 1) % 5 == 0)
				System.out.println();
		}
		int[][] b = SnackArray.loopMatrix2(4);
		for (int i = 0; i < b.length; i++) {
			System.out.println();
			for (int j = 0; j < b[0].length; j++) {
				System.out.print(b[i][j] + ",");
			}
		}
		System.out.println();
	}
}
