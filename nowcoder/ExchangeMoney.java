package nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 美团
 * 给你六种面额 1、5、10、20、50、100 元的纸币,假设每种币值的数量都足够多
 * 编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数。 
 *  不可以用生成函数 阶乘(r+k-1/r)  r元的 因为k种面值是确定的
 * @author {wqz}
 *
 * @date 2017年8月28日 下午7:55:15
 */
public class ExchangeMoney {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        System.out.println(count(n));
	}
//	public static int jumpFloor(int number) {
//		if(number<0){
//			return 0;
//		}else if(number == 0)
//            return 1;
//		else if(number == 1)
//            return 1;
//        else
//            return jumpFloor(number-1) + jumpFloor(number-5)+ jumpFloor(number-10)+ jumpFloor(number-20)+ jumpFloor(number-50)+ jumpFloor(number-100);
//    }  //和跳台阶不一样
	public static long count(int n) {  
        int coins[] = {1,5,10,20,50,100};  
        int h = coins.length;  
        long dp[][] = new long[h][n + 1];  
        Arrays.fill(dp[0], 1);  
        for (int i = 1; i < h; i++) {  
            for (int j = 0; j <= n; j++) {  //j要从0开始
                int m = j/coins[i];  
                for (int k = 0; k <= m; k++) {  
                    dp[i][j] = dp[i][j] + dp[i - 1][j - k * coins[i]];  
                    //if(i==2) System.out.println(dp[i][j]);
                }  
            }  
        }  
        return dp[h - 1][n];  
    }  
	public static long count2(int n){
        if(n <= 0)return 0;
        int[] coins = new int[]{1,5,10,20,50,100};
        long[] dp = new long[n+1];
        dp[0] = 1;
        for(int i = 0; i < coins.length; i++) {
        for(int j = coins[i]; j <= n; j++) {
        dp[j] = dp[j] + dp[j - coins[i]];//类似斐波那契 后者的种类数基于前者
        }
    }
    return dp[n];
    }
}
