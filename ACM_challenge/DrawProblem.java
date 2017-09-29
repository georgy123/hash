package ACM_challenge;

import java.util.Arrays;
import java.util.Random;

/**
 * 抽签问题
 * 将写有数字的n个纸片放入口袋中，你可以从口袋中抽取4次纸片，每次记下纸片上的数字后都将其放回口袋中。如果这4个数字的和是m，就是你赢，否则就是你的朋友赢。
         请你编写一个程序，判断当纸片上所写的数字是k1，k2，... ，kn时，是否存在抽取4次和为m的方案
 *
 *@author Administrator
 *
 * @date 2017年2月16日
 */
public class DrawProblem {
	/**
	 * 
	 * @param n 放入口袋的纸片数
	 * @param m  抽取的4个纸片数之和
	 * @param k   数组
	 */
      public static int slove(int n,int m,int[] k){
    	  int flag=0;
    	  for(int a =0;a<n;a++){
    		  for(int b =0; b<n;b++){
    			  for(int c=0; c<n;c++){
    				  for(int d =0; d<n;d++){
    					  if(k[a]+k[b]+k[c]+k[d]==m){
    						  flag=1;
    						  System.out.println(k[a]+","+k[b]+","+k[c]+","+k[d]);
    					  }
    				  }
    			  }
    		  }
    	  }
    	  return flag;
      }
      /**
       * 快速排序只分區
       * @param s
       * @param low
       * @param high
       * @return
       */
      public static int partion(int[] s,int low,int high){
    	  int key =s[low];
    	  int l = low;
    	  int h = high;
    	  while(l<h){
    		  while(l<h && key <=s[h]){
    			  h--;
    		  }
    		  s[l] = s[h];
    		  while(l<h && key>=s[l]){
    		       l++;	  
    		  }
    		  s[h] = s[l];
    	  }
    	  s[h]=key;
    	  return h;
      }
      /**
       * 產生不重复的隨機數
       * @param n
       * @return
       */
      public static int[] randomNum(int n){
    	boolean [] isUsed = new boolean[n];
  		int[] s = new int[n];
  		Random random = new Random(System.currentTimeMillis());
  		int i =0;
  		while(true){
  			int index = random.nextInt(n);
  			if(isUsed[index]){
  				continue;
  			}
  			s[i++] = index;
  			isUsed[index] = true;
  			if(i==s.length){
  				break;
  			}
  		}
  		return s;
      }
      /**
       * 快速排序
       * @param s
       * @param low
       * @param high
       */
      public static void quickSort(int[] s, int low, int high){
    	  if(low < high){
    		  int index = partion(s,low,high);
    		  quickSort(s,low,index-1);
    		  quickSort(s,index+1,high);
    	  }
      }
      public static void main(String[] args) {
		int[] k= new int[]{1,3,5};
		int slove = slove(3,10,k);
		if(slove ==1){
			System.out.println("Yes");
		}
		int[] s = new int[]{72,92,6,57,88,60,42,83,73,48,85,63,21};
		int[] s1 = randomNum(100000);
		
		long start = System.currentTimeMillis();
		//quickSort(s1,0,s1.length-1);
		Arrays.sort(s1);
		long end = System.currentTimeMillis();
		for(int i=0;i<s1.length;i++){
			System.out.print(s1[i]+",");
		}
		System.out.println();
		System.out.println("耗時："+(end-start));
	}
}
