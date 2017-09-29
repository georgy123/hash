package algorithms;

/**
 * 两矩阵相乘
 * 
 *三个for循环：第一个for循环是a的行，第二个for循环是b的列，第三个for循环是a，b共同的部分
 *@author {wqz}
 *
 * @date 2017年8月19日 下午4:27:36
 */
public class MatrixMultiply {
	/**
	 * 
	 * @param a 矩阵a
	 * @param b 矩阵b
	 * @param p 矩阵a的行
	 * @param q 矩阵a的列，矩阵b的行
	 * @param r 矩阵b的行
	 * @return res结果
	 */
    public static double[][] MatrixM(int[][] a,int[][] b,int p,int q,int r){
    	if(a[0].length!=b.length){
    		System.out.println("Please input right matrix!");
    		return null;
    	}
    	double[][] res = new double[p][r];
    	for (int i = 0; i < p; i++) {
			for (int j = 0; j < r; j++) {
				for (int k= 0; k < q; k++) {
					res[i][j] += a[i][k]*b[k][j];
				}
			}
		}
    	return res;
    }
    public static void main(String[] args) {
		int[][] a ={{1,2,3},{4,5,6}};
		int[][] b ={{1,2},{4,5},{7,8}};
		double[][] matrixM = MatrixM(a, b, a.length, b.length, b[0].length);
		for (int i = 0; i < matrixM.length; i++) {
			for (int j = 0; j < matrixM[i].length; j++) {
				System.out.print(matrixM[i][j]+" ");
			}
			System.out.println();
		}
	}
}
