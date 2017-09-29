package algorithms.test;

public class ProblemTest {
	
     public String getName(String name){
    	 return null;
     }
     public void getName(int name){
     }
     static void pong() {
         System.out.print("pong");
	}
     public static void print(){
    	 System.out.println("MTDP");
    	 }
     public static void main(String[] args) {
//    	 String str1 = "hello";
//    	 String str2 = "he" + new String("llo");
//    	 System.err.println(str1 == str2);
//    	 Thread t = new Thread() {
//             public void run() {
//                 pong();
//             }
//         };
//         t.run();
//         System.out.print("ping");
//         
//         System.out.println(System.getProperty("user.dir"));
//         System.out.println(2^2*3-1+1/3+2*(1234+5));
//         System.out.println(2^2*3);
//         double d1=-0.5;
//         System.out.println("Ceil d1="+Math.ceil(d1));
//         System.out.println("floor d1="+Math.floor(d1));
//         boolean b=true?false:true==true?false:true;
//         System.out.println(b);
//         for (int i = 0; i < 5; i++) {
//        	 
//			for (int j = 0; j < 3; j++) {
//				if(i==1 && j==0){
//					continue;
//				}
//				System.out.print(j+",");
//			}
//			System.out.println();
//		}
//         System.out.println((124 & 1)==1);
//         System.out.println();
//    	 int i=5;
//    	 ++i;
//    	 int a =i--;
//    	 System.out.println(a+":"+i);
//    	 System.out.println(Math.pow(3, 2));
    	 int a=1;
    	 int b=32;
    	 System.out.println(1<<32);
    	 try{
        	 ((ProblemTest)null).print();
        	 }catch(NullPointerException e){
        	 System.out.println("NullPointerException");
        	 }	
    	 int a1 =8;
    	 int b2=7;
    	 int x=9;
    	 if(--a1==b2) x=++a1*x;
    	 else
    		 x=--a1*x;
    	 System.out.println(x);
     }
     
}
