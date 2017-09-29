package algorithms.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;

import algorithms.LcsLength;
import algorithms.MatrixChain;

public class LcsLengthTest {
public static void main(String[] args) {
	  
	char []a = {'A','B','C','B','D','A','B'};
	char []b = {'B','D','C','A','B','A'};
//	String a = "ABCBDAB";
//	String b = "BDCABA";
    // int[][] m = LcsLength.LCSLength(a, b);
     //LcsLength.lcsPrint(a, b,m, a.length, b.length);
    // String[] c =  LcsLength.lcsPrint(a, b, m);;
//     for (int i = 0; i < c.length; i++) {
//    	if(c[i]!=null){
//    		System.out.print(c[i]);
//    	}
//	}
//	char []c = {'A','B','C','B','D','A','B'};
//	char []d = {'A','D','F','M','B','H'};
	String c = "21232523311324";
	String d = "312123223445";
     LcsLength.LCString(c.toCharArray(), d.toCharArray());
     
    // LcsLength.lcsPrintStr(a, b, m, a.length, b.length);
//     for (int i =0;i<m.length;i++) {
//    	 System.out.println();
//    	 for(int j =0; j<m.length-1; j++){
//    		 System.out.print(m[i][j]+"\t");
//    	 }
//		
//	}
     
}
	
}
