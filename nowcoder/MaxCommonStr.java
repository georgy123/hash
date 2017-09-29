package nowcoder;

import java.util.Scanner;

/**
 * 给出两个字符串（可能包含空格）,找出其中最长的公共连续子串,输出其长度。
输入描述:

输入为两行字符串（可能包含空格），长度均小于等于50.

输出长度
 * 
 *
 *@author {wqz}
 *
 * @date 2017年8月29日 下午4:06:45
 */
public class MaxCommonStr {
    public static int LCString(char[] x,char[] y){
		   int [][] c = new int[x.length+1][y.length+1];
		   int max = 0;
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
				   }   
		   } 
	  }	
		   return max;
 }
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str1 = in.nextLine();
		String str2 = in.nextLine();
        System.out.println(LCString(str1.toCharArray(),str2.toCharArray()));
    }
}
