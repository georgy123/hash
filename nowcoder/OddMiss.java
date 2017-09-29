package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OddMiss {
     public static int getLastNum(int n){
    	 List<Integer> list = new ArrayList<Integer>();
         for (int i = 0; i <= n; i ++ )
             list.add(i);
         while (list.size() != 1) {
             // 从0开始list移除一次,i再加一次,i始终指向奇数位
             for (int i = 0; i < list.size(); i = i + 1)
                 list.remove(i);
         }
        return list.get(0);
    	 
     }
     public static void main(String[] args) {
//    	 Scanner sc = new Scanner(System.in);
//         while (sc.hasNext()) {
//             int n = sc.nextInt();
//             System.out.println(getLastNum(n));
//         }
    	 System.out.println();
    	 try{
    		 Integer valueOf = Integer.valueOf("abc");
    	 }catch(NumberFormatException e){
    		 System.out.println("error");
    	 }
	}
}
