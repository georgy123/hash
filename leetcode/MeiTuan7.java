package leetcode;

import java.util.Scanner;

public class MeiTuan7 {
   public static void main(String[] args) {
	  Scanner in = new Scanner(System.in);
	  int n = in.nextInt();
	  int[] a = new int[n];
	  for(int i=0;i<a.length;i++){
		  a[i]=in.nextInt();
	  }
	  int count=0;;
	  for (int i = 0; i < a.length; i++) {
		for (int j = i+1; j < a.length; j++) {
			String s = a[i]+""+a[j];
			String s2 =a[j]+""+a[i];
			//int b=Math.abs(Integer.parseInt(s.substring(s.length()-3, s.length()))-Integer.parseInt(s.substring(0, s.length()-3)));
		    if(Integer.parseInt(s)%7==0){
		    	count++;
		    }
		    if(Integer.parseInt(s2)%7==0){
		    	count++;
		    }
		}
	}
	  System.out.println(count);
   }
}
