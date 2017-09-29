package mianshi;

import java.util.Scanner;

public class Main2 {
  public static void main(String[] args) {
	  Scanner in = new Scanner(System.in);
	  int n = in.nextInt();
	  String[] a = new String[n];
	  String[] b = new String[n*(n-1)/2];
	  for (int i = 0; i < a.length; i++) {
		a[i]=in.nextLine();
	}
	  for (int i = 0; i < b.length; i++) {
		b[i]=in.nextLine();
	}
	  for(int i = 0; i < 1; i++){
		  System.out.println(a[i]);
	  }
	  System.out.println(a[n-1]);
}
}
