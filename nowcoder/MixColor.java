package nowcoder;

import java.util.Scanner;

public class MixColor {
    public static void main(String[] args) {
//    	 Scanner in = new Scanner(System.in);
//   	     while(in.hasNext()){
//   		        int n = in.nextInt();
//   		        int[] numbers = new int[n];
//   		        for(int i=0; i<n; i++){
//   		        	numbers[i]=in.nextInt();
//   		        }
//   		        
//   	    }
    	String[] split = "d|s|d".split("\\|");
    	for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
		}
    	System.out.println(split.toString());
    	//System.out.println("d|s|d"..);
	}
}
