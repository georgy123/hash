package ACM_challenge;

import java.util.Scanner;
/**
 * 
 * 旋转打印矩阵
 *
 *@author Administrator
 *
 * @date 2017年4月21日 下午8:06:11
 */
public class Rotate {
	public static void rotate(int[][] matrix, int n) {
	    for (int layer = 0; layer < n / 2; ++layer) {
	        int first = layer;
	        int last = n - 1 - layer;
	        for(int i = first; i < last; ++i) {
	            int offset = i - first;
	            int top = matrix[first][i]; // save top

	            // left -> top
	            matrix[first][i] = matrix[last-offset][first];          

	            // bottom -> left
	            matrix[last-offset][first] = matrix[last][last - offset]; 

	            // right -> bottom
	            matrix[last][last - offset] = matrix[i][last]; 

	            // top -> right
	            matrix[i][last] = top; // right <- saved top
	        }
	    }
	    for (int i = 0; i < matrix.length; i++) {
			for(int j=0;j<matrix[j].length;j++){
				System.out.print(matrix[i][j]);
			}
			
		}
	}
     public static void main(String[] args) {
    	  Scanner in = new Scanner(System.in);
    	  while(in.hasNext()){
    		  int m= in.nextInt();
    		  int n= in.nextInt();
    		  int r = in.nextInt();
    		  int[][] martix = new int[m][n];
    		  for(int i=0;i<m;i++){
    			  for(int j=0;j<n;j++){
    				  martix[i][j]= in.nextInt();
    			  }
    		  }
    		  rotate(martix,r);
    	  }
	}
}
