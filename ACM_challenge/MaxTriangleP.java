package ACM_challenge;

import java.util.Arrays;
 /**
  * 
  * 求最大三角形的周长
  *
  *@author Administrator
  *
  * @date 2017年2月13日
  */
public class MaxTriangleP {
     
	public static int[] MaxTP(int n,int[] a){
		int[] temp = new int[n]; //临时数组降序
		int[] ans = new int[4]; //存放结果，周长，边长
		//int found =0; //是否找到这样的三角形的标志 1 找到
		Arrays.sort(a);
		for(int i = 0; i<a.length; i++){
			temp[a.length-1-i] = a[i];
		}
		for(int j =0; j<temp.length; j++){
			if(temp[j] < temp[j+1]+temp[j+2]){
				ans[0] = temp[j]+temp[j+1]+temp[j+2];
				ans[1] = temp[j];
				ans[2] = temp[j+1];
				ans[3] = temp[j+2];
                break;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] a = new int[]{2,5,4,3,10};
		int[] maxTP = MaxTP(5, a);
		for(int n =0;n<maxTP.length;n++){
			System.out.println(maxTP[n]);
		}
	}
}
