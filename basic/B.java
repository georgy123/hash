package basic;

import java.util.ArrayList;

public class B extends A{
   public int m=1;
   public void said(){
	   super.said();
	   System.out.println("B:"+m);
   }
   public void get(){
	   System.out.println("dfdfdfdfdf");
   }
   public static void main(String[] args) {
	    A a = new B();
	    System.out.println(a.m);
	    a.said();
	   Integer.valueOf("12");
	    B b=(B)a;
	    b.get();
	   System.out.println( b instanceof A);
	   Integer n =0;
	   for(int i=0;i<10;i++){
		   n++;
	   }
	   System.out.println(n);
	   Integer c = 3;
       Integer d = 3;
       Integer e = 6;
       int f =3;
       Long g =6l;
       System.out.println(c==f);  //-127-128静态缓存数组，直接取，超过时new Integer（）
       try{
    	   
       }finally{
    	  
       }
        System.out.println(3+(3>>1));
}
   
}
