package nowcoder;

import java.util.Scanner;
import java.util.Stack;

/**
 * 美团
 * 给定一组非负整数组成的数组h，代表一组柱状图的高度，其中每个柱子的宽度都为1。 
 * 在这组柱状图中找到能组成的最大矩形的面积（如图所示）。 入参h为一个整型数组，代表每个柱子的高度，返回面积的值。 
 *如 高度为5,4，5   最大面积为：3*4=12
 *输入包括两行,第一行包含一个整数n(1 ≤ n ≤ 10000)
     第二行包括n个整数,表示h数组中的每个值,h_i(1 ≤ h_i ≤ 1,000,000)
 *@author {wqz}
 *
 * @date 2017年8月29日 下午3:11:31
 */
public class MaxArea {
     public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] h = new int[n];
		for(int i= 0; i<n; i++){
			h[i] = in.nextInt();
		}
		int max =0;
		
		for (int i = 0; i < h.length; i++) {
			int count=0;
			if(i-1>=0){
				for (int j = i-1; j>=0; j--) {
					if(h[j]<h[i]) break;
					else count++;
				}
			}
			if(i+1<h.length){
				for (int k = i+1; k<=h.length-1; k++) {
					if(h[k]<h[i]) break;
					else count++;
				}
			}
			max=h[i]*(count+1)>max?h[i]*(count+1):max;
		}
		System.out.println(max);
	}
     /**
      * 单调栈
      * @param height
      * @return
      */
    	 private static int  getmax(int[] height) {
    	        int len = height.length;
    	         Stack<Integer> s = new Stack<Integer>();
    	         int maxArea = 0;
    	         for(int i = 0; i <= len; i++){
    	             int h = (i == len ? 0 : height[i]);
    	             if(s.isEmpty() || h >= height[s.peek()]){
    	                 s.push(i);
    	             }else{
    	                 int tp = s.pop();
    	                 maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
    	                 i--;
    	             }
    	         }
    	         return maxArea;
    	     }
}
