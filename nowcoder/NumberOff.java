package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 报数游戏 有n个孩子站成一圈，从第一个孩子开始顺时针方向报数，报到3的人出列，下一个人继续从1报数， 
 * 直到最后剩下一个孩子为止。问剩下第几个孩子。 
 * 
 *
 *@author {wqz}
 *
 * @date 2017年8月30日 上午10:32:01
 */
public class NumberOff {
	public static void numberOff(List lis,int m){  
        while(lis.size()>1){  
            for(int i=0;i<m-1;i++)   
                lis.add(lis.remove(0));  
            lis.remove(0);  
        }  
        System.out.println("剩下最后一个人为："+lis);  
    }  
    // 输入数据  
    public static int input(List lis){  
        Scanner scan = new Scanner(System.in);  
        System.out.print("输入人数：");  
        int n = scan.nextInt(); // 输入人数  
        System.out.print("输入报数到 m 出列（m）：");  
        int m = scan.nextInt(); // 输入报数到 m 出列  
        for(int i=0;i<n;i++) lis.add(i+1);  
        return m;  
    }  
    public static void main(String[] args){  
        List lis = new ArrayList();  
       // int m = input(lis); // 输入数据  
       // numberOff(lis,m);   // 开始报数  
        lis.add(1);
        lis.add(2);
        lis.add(3);
        System.out.println(lis.remove(2));
    }  
}
