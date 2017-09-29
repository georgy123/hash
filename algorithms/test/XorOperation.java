package algorithms.test;

import java.util.Arrays;

/**
 * 
 * 位运算
 *
 *@author Administrator
 *
 * @date 2017年6月26日 下午4:13:20
 */
 class XorOperation {
	/**
	 * 统计整数中1的个数
	 * @param a
	 * @return
	 */
     public int bitNums(long a){
    	 int count =0;
    	 long c =a;
    	 while(c!=0){
    		 c=c & (c-1);
    		 count++;
    	 }
    	 return count;
     }
     /**
      * 判断一个整数是否为2的整数次方
      * 那么它的二进制表示中有且仅有一个位是1，而其他所有位都是0，把这个整数减去1后再与自己相“与”，唯一的1也会变成0
      * @param number
      * @return boolean
      */
     public boolean is2Power(long number){
    	 if((number & (number-1))==0) return true;
    	 else return false;
     } 
     /**
      * 异或交换两个数(except two numbers is equal)
      * @param a
      * @param b
      * 实际上并不会真正的改变形参不能改变实参
      */
     public void swap(int a,int b){
    	 a=a^b;
    	 b=b^a;
    	 a=a^b;
    	 System.out.println(a+","+b);
  	    
     }
     /**
      * 异或满足交换律
      * 整数型数组中，每个元素均出现两次，除了一个元素例外，如何找出这个元素？能否设计一个线性时间的算法，且不需要额外的存储空间
      * @param a 判断的数组
      * @param n 大小
      * @return 不重复的数
      */
     public int singleNum(int[] a){
    	 int res =0;
    	 for (int i = 0; i < a.length; i++) {
			res^=a[i];
		}
    	 return res;
     }
	 public static void swap(int a[]){      
 		//数组传递实现交换两个整数  
 		    int t;  
 		    t = a[0];  
 		    a[0] = a[1];  
 		    a[1] = t; 
}
     public static void main(String[] args){
    	 System.out.println(new XorOperation().bitNums(8));
    	 System.out.println(new XorOperation().is2Power(32));
    	 new XorOperation().swap(45, 78);
    	 int[] a ={12,45,78,16};
    	 for (int i = 0; i < a.length-1; i++) {
			a[i]=a[i]^a[i+1];
			a[i+1]=a[i]^a[i+1];
			a[i]=a[i]^a[i+1];
		}
    	 String str = Arrays.toString(a);
			System.out.println(str);
			int [] b= new int[2];  
		     b[0] = 3;  
		     b[1] = 4;  
		     swap(b);  
		     System.out.println(b[0] + "," + b[1]);
		     System.out.println("not repeat:"+new XorOperation().singleNum(new int[]{2,1,4,5,2,4,1}));
     }
}
