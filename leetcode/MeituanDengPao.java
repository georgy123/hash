package leetcode;

import java.util.Scanner;

public class MeituanDengPao {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		  int n = in.nextInt();
		  int temp=0;
		  int i=0;
		  while(i++<=n){
			   temp = in.nextInt();
		  }
		  if(temp==1){
			  System.out.println("Alice");
		  }else{
			  System.out.println("Bob");
		  }
	}   
}
