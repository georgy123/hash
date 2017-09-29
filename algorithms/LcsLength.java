package algorithms;

import java.util.ArrayList;
import java.util.List;


/**
 * 最长公共子串&最长公共子序列
 * @author wqz
 *
 */
public class LcsLength {
       /**
        * 最长公子序列
        * @param x
        * @param y
        * @return 二维数组
        */
	   public static int [][] LCSLength(char[] x,char[] y){
		   int [][] c = new int[x.length+1][y.length+1];
		   //int [][] b = new int[x.length+1][y.length+1];
		   for(int i =0; i<=x.length; i++){
			   c[i][0] = 0;
		   }
		   for(int j =0; j<=y.length; j++){
			   c[0][j] = 0;
		   }
		   for(int i =1; i<=x.length; i++)
			   for(int j=1; j<=y.length; j++){
				   if(x[i-1]==y[j-1]){
					   c[i][j] = c[i-1][j-1]+1;
					  // b[i][j]=1;  //对应的子问题
				   }
				 //比较“左边”和“上边“，根据大的来填充
				   else if(c[i-1][j]>=c[i][j-1]){
					   c[i][j] = c[i-1][j];
					 //  b[i][j] = 2;
				   }
				   else{
					   c[i][j] = c[i][j-1];
					  // b[i][j] = 3;
				   }
			   }
		   return c;
	   }
	   /**
	    * 回溯最长公共子序列
	    * @param x
	    * @param y
	    * @param c
	    * @param i
	    * @param j
	    */
    public static void lcsPrint(char[] x,char[] y,int [][]c,int i,int j){
    	if(i==0 || j==0){
    		return;
    	}
    	if(x[i-1]==y[j-1]){
    		System.out.print(x[i-1]);
    		lcsPrint(x, y, c,i-1,j-1);
    	}else if(c[i-1][j]>=c[i][j]){
    		lcsPrint(x, y, c, i-1, j);
    	}else{
    		lcsPrint(x, y, c, i, j-1);
    	}
    }
    //非递归形式
    public static String[] lcsPrint(char[] x,char[] y,int[][] c){
    	int i =x.length;
    	int j=y.length;
    	String [] m = new String[y.length];
    	while(i>0 && j>0){
    		if(x[i-1]==y[j-1]){
    			//System.out.print(x[i-1]);
    			 m[i-1]=String.valueOf(x[i-1]);
    			i--;
    			j--;
    		}else if(c[i-1][j]>=c[i][j-1]){
    			i--;
    		}else{
    			j--;
    		}
    	}
    	return m;
 }
    /**
     * 最长公共子串
     * @param x
     * @param y
     * @return
     */
    public static void LCString(char[] x,char[] y){
		   int [][] c = new int[x.length+1][y.length+1];
		   int max = 0;
		   int[] end = new int[x.length]; //最长公共子串（有时可能不止一个）的起始位置
		   for(int i =0; i<=x.length; i++){
			   c[i][0] = 0;
		   }
		   for(int j =0; j<=y.length; j++){
			   c[0][j] = 0;
		   }
		   for(int i =1; i<=x.length; i++){
			   for(int j=1; j<=y.length; j++){
				   if(x[i-1]==y[j-1]){
					   c[i][j] = c[i-1][j-1]+1;
				   }
				   else {
					   c[i][j] = 0;
				   }
				   if(c[i][j]>max){
					   max = c[i][j];
					  end[0] = i-1;
					   for(int k =1; k<end.length; k++){
						   end[k] = 0;         //初始化为0方便判断是否已赋过值					   }
				       }
				   }
				   else if(c[i][j]==max){
					   for(int k =1; k<end.length; k++){
						   if(end[k]==0){   //end中还未賦值
							   end[k] = i-1;
							   break;
						   }
						   
					   }
				   }
			   
		   } 
	}
		   for(int i = 0; i<end.length; i++){
			   System.out.println();
			   if(end[i]>0 || i==0 ){  //若没有这个会重复输出下标从0开始的字符串，因为start初始化为0
				   for(int j =end[i]-max+1; j <= end[i]; j++){
						  System.out.print(x[j]);
					       }
			   }
		      
		 }
		
    }  
}