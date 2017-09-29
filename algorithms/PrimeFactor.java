package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 当一个数很大的时候求质因数的方法求约数的个数比穷举要快
 *判断是否为质因数
 *求出质因数的个数比如18的质因数2,3,3
 *来求该数的约数的个数 （1+1）*（2+1）
 *@author Administrator
 *
 * @date 2017年3月21日
 */
public class PrimeFactor {
	/**
	 * 求质因数
	 * @param number
	 */
	public static int[] primeFactor(int number){ 
		    // Find all the smallest factors of the integer  
		    int [] factors = new int[65536];  //0的位置存放的是元素的个数
		    System.out.println("The factors for " + number + " is");  
		    int factor = 2;
		    while (factor <= number) {  
		      if (number % factor == 0) {  
		        number = number / factor;  
		        //System.out.println(factor); 
		        factors[factors[0]+1]=factor;
		        factors[0]++;
		      }  
		      else {  
		        factor++;  
		      }  
		    } 
		    return factors;
	}
	/**
	 * 用质因子求约数的个数
	 * @param number
	 * @return
	 */
	public static int sumprimeFactor(int number){ 
    	 int[] pf = primeFactor(number); 
    	 int sum = 1;
    	 int i=1;
    	 int counti =0;
    	 while(i<=pf[0]){
    		 int count =0;
    		for(int j=i;j<=pf[0];j++){
    			 if(pf[i]==pf[j]){
    				 count++;
    				 counti++;
    			 }
    		 }
    		i=counti+1;
    		sum=sum*(count+1);
    	 }
    		 
    	
	    return sum;
}
	/**
	 * 穷举一个数约数的个数
	 * @param n 要求得数
	 * @return 该数的约数个数
	 */
    public static int sumFactor(int n){
    	int count =0;
    	 for(int i=1; i<=n; i++){
		    	if(n%i==0){
		    		count++;
		    	}
		    }
    	 return count;
    }
    /**
     * 一个数的所有约数
     * @param n
     * @return 返回所有约数
     */
    public static List allFactors(int n){
    	List factors =new ArrayList();
    	 for(int i=1; i<=n; i++){
		    	if(n%i==0){
		    		factors.add(i);
		    	}
		    }
    	 return factors;
    }
	public static void main(String[] args) {
		 java.util.Scanner input = new java.util.Scanner(System.in);  
		    // Prompt the user to enter a positive integer  
		    System.out.print(  
		      "Enter a positive integer: ");  
		    int number = input.nextInt(); 
		    long start1 = System.currentTimeMillis();
		    int sumprimeFactor = PrimeFactor.sumprimeFactor(number);
		    long end1 = System.currentTimeMillis();
		    System.out.println("dddddd:"+sumprimeFactor+"耗时："+(end1-start1));
		    long start = System.currentTimeMillis();
		    int count =PrimeFactor.sumFactor(number);
		    long end = System.currentTimeMillis();
		    System.out.println("kkkk0:"+count+"耗时："+(end-start));
		  
	}
}
