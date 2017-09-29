package algorithms;

/**
 * 矩阵连乘
 * @author Administrator
 *
 * @date 2017年2月12日
 */
public class MatrixChain {

	public static void matrixChain(int[] p, int n, int[][] m, int[][] s) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j<=n; j++) {
				m[i][j] = 0;
			}
		}
		for (int r = 2; r <= n; r++) {
			for (int i = 1; i < n - r + 1; i++) {
				int j = i + r - 1;
				m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
				s[i][j] = i;
				for (int k = i + 1; k < j; k++) {
					int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[i] * p[j];
					if (t < m[i][j]) {
						m[i][j] = t;
						s[i][j] = k;
					}
				}

			}

		}
	}
	public static void matrixChain1(int[] p, int n, int[][] m, int[][] s) {
		for (int i = 1; i <= n; i++) {
			m[i][i]=0;
		}
		for(int i = n-1; i >= 1; i--)
			for(int j = i+1; j <= n; j++){
				int min = m[i][j] + m[i+1][j] + p[i-1] * p[i] * p[j];
				for(int k = i+1; k < j; k++){
					int t = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j];
					if(t < min) min = t;
				}
				m[i][j] = min;
			}
	}
	public static int [][] matrixChain1(int[] p) {
		int [][] m = new int[p.length][p.length];
		//int [][] s = new int[p.length][p.length];
		int n = p.length-1;
		for (int i = 1; i <= n; i++) {
			m[i][i]=0;
		}
		for(int i = n-1; i >= 1; i--)
			for(int j = i+1; j <= n; j++){
				int min = m[i][j] + m[i+1][j] + p[i-1] * p[i] * p[j];
				for(int k = i+1; k < j; k++){
					int t = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j];
					if(t < min) min = t;
				}
				m[i][j] = min;
			}
		return m;
	}
}
