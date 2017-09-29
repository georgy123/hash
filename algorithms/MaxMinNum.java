package algorithms;

public class MaxMinNum {
   
/**
 * 辗转相除求最大公约数
 * @param m
 * @param n
 * @return 最大公约数
 */
public static int maxDivisor(int m ,int n){
		int a=m;
		int b=n;
		if(a<b){
			int temp;
			temp =a;
			a=b;
			b=temp;
		}
		while(b!=0){
			int temp;
			temp = a%b;
			a=b;
			b=temp;
		}
		return a;
	}
/**
 * 穷举法求最小公倍数
 * @param m
 * @param n
 * @return i
 */
public static int minDivisor(int m ,int n){
	int a=m;
	int b=n;
	int i =0;
	if(a<b){
		int temp;
		temp =a;
		a=b;
		b=temp;
	}
	for(i=a;;i++){
		if(i%a==0 && i%b==0){
			break;
		}
	}
	return i;
}
/**
 * 两数乘积除以它们的最大公约数求最小公倍数
 * @param m
 * @param n
 * @return i
 */
public static int minMaxDivisor(int m ,int n){

	return m*n/maxDivisor(m ,n);
}
public static void main(String[] args) {
	 long start = System.currentTimeMillis();
	 //System.out.println(MaxMinNum.maxDivisor(2147483647,366599854));
	 System.out.println(MaxMinNum.minDivisor(45553,42556));
	 System.out.println(MaxMinNum.minMaxDivisor(45553,42556));
	 long end = System.currentTimeMillis();
	 System.out.println("耗时："+(end-start));
   }
}
