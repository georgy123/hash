package algorithms;

import java.util.Arrays;
import java.util.Scanner;

//public class Main2 {
//  public static void main2(String[] args) {
//	Scanner in = new Scanner(System.in);
//	int n = in.nextInt();
//	int s = in.nextInt();
//	int sum=0;
//	int[] a = new int[n];
//	
//	for (int i = 0; i < n; i++) {
//		a[i]=in.nextInt();
//	}
//	int count=0;
//	for (int i = 0; i < a.length; i++) {
//		sum+=a[i];
//		if(sum<=s){
//			count++;
//		}
//	}
//	System.out.println(count);
//}
//  public static void main(String[] args) {
//	    Scanner in = new Scanner(System.in);
//		int a = in.nextInt();
//		int b = in.nextInt();
//		int c = in.nextInt();
//		int[] temp = {a,b,c}; 
//		Arrays.sort(temp);
//		int max =0;
//		for (int i = temp[0]; i >=1; i--) {
//			for (int  j= temp[1]; j>=1; j--) {
//				for (int k = temp[2]; k>=1; k--) {
//					if(k<i+j){
//						max=max>i+j+k?max:i+j+k;
//					}
//				}
//			}
//		}
//		
//		System.out.println(max);
//}
//	public static int MaxTP(int[] a){
//		int[] temp = new int[a.length]; //临时数组降序
//		int ans =0;
//		Arrays.sort(a);
//		for(int i = 0; i<a.length; i++){
//			temp[a.length-1-i] = a[i];
//		}
//		for(int j =0; j<temp.length; j++){
//			if(j+1<temp.length&& j+2<temp.length){
//				if(temp[j] < temp[j+1]+temp[j+2]){
//					ans= temp[j]+temp[j+1]+temp[j+2];
//	                break;
//				}
//			}
//		}
//		return ans;
//	}
//}
public class Main2 {
	  public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int count=0;
		for (int i = 0; i <s.length(); i++) {
			if(s.charAt(i)=='R'){
				count++;
			}
		}
		s=s.replaceAll("R", "1").replaceAll("G", "0");
		long a = Long.parseLong(s, 2);
		//System.out.println(a);
		String res = "";
		for (int i = 0; i <count; i++) {
			res+="1";
		}
		for (int i = 0; i <s.length()-count; i++) {
			res+="0";
		}
		long b =Long.parseLong(res, 2);
		//System.out.println(b);
		long c = Long.parseLong(Long.toBinaryString(a^b), 2);
		 //System.out.println(c);
		 int count2 =0;
    	 while(c!=0){
    		 c=c & (c-1);
    		 count2++;
    	 }
    	 System.out.println(count2++);
	}
}