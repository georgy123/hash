package nowcoder;

import java.math.BigInteger;
import java.util.Scanner;

public class IntegerAddM {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			try {
				 BigInteger a = in.nextBigInteger();
				 BigInteger b = in.nextBigInteger();
				 System.out.println(a.add(b));
				
			} catch (NumberFormatException e) {
				System.out.println("Error");
			}
		}
		
	}
}
