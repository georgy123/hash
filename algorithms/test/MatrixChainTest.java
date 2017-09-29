package algorithms.test;

import algorithms.MatrixChain;

public class MatrixChainTest {
	public static void main(String[] args) {
		int [] p = new int[]{30,35,15,5,10,20,25};
//		int [][] m = new int[p.length][p.length];
//		int [][] s = new int[p.length][p.length];
//		MatrixChain.matrixChain1(p, p.length-1,m,s);
		int[][] m = MatrixChain.matrixChain1(p);
		for (int i = 1; i < m.length; i++) {
			System.out.println();
			for(int j = 1; j<m.length;j++){
				System.out.print(m[i][j]+"\t");	
			}
		}
	}

}
