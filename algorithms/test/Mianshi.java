package algorithms.test;

public class Mianshi {
     public static void main(String[] args) {
    	 int i=0;
         int j=0;
         boolean t =true;
         boolean r;
         r=(t&(0<(i+=1)));
         System.out.println(r);
         r=(t && (0<(j+=2)));
         System.out.println(r);
         r=(t | (0<(i+=2)));
         
         r=(t || (0<(j+=1)));
         System.out.println("i:"+i+","+"j:"+j);
	}
}
