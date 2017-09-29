package leetcode;
/**
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer. 
 * 
 *动态规划的题 最优子结构性质   本次结果=前两次结果的和
 *斐波那契数列
 *.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)
c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2) 
d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2
e.可以发现最终得出的是一个斐波那契数列：
              | 1, (n=1)
f(n) =        | 2, (n=2)
              | f(n-1)+f(n-2) ,(n>2,n为整数)
public class Solution {
    public int JumpFloor(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else if (target ==2) {
            return 2;
        } else {
            return  JumpFloor(target-1)+JumpFloor(target-2);
        }
    }
}
 *@author {wqz}
 *
 * @date 2017年7月23日 上午9:54:16
 */
public class ClimbingStairs {
	 public int climbStairs(int n) {
		 int[] res = new int[n+1];
		 res[0]=1;
		 res[1]=1;
		 for(int i=2; i<=n;i++){
			 res[i] = res[i-1]+res[i-2];
		 }
			return res[n];	 
	    }
	 /**
	  *  斐波纳契 空间复杂度为1
	  * @param n
	  * @return
	  */
	 public int climbStairs2(int n) {
		 int res = 1;
		 int a = 1;
		 int b = 1;
		 for(int i=1; i<n;i++){
			 res=a+b;
			 a=b;
			 b=res;
		 }
			return res;	 
	    }
	 /**
	  * 递归的情况
	  * @param number
	  * @return
	  */
    public int jumpFloor(int number) {
		         if(number <= 0)
		             return 0;
		         else if(number == 1)
		             return 1;
		         else if(number == 2)
		             return 2;
		         else
		             return jumpFloor(number-1) + jumpFloor(number-2);
		     }
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
     * @param n
     * @return
     */
    public static int climbStairs3(int target) {
	   //return (int)Math.pow(2, target-1);	 
//    	 if(target <= 2)
//             return target;
//         else
//             return climbStairs3(target - 1) * 2;   //数大的话StackOverflowError
//    	if(target == 0) {
//            return 0;
//        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= target;i++) {
            dp[i] = 0;
            for(int j = 0;j < i;j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target];   //数很大时会超过int的范围
	    }
	 public static void main(String[] args) {
		 long start = System.currentTimeMillis();
		System.out.println(new ClimbingStairs().climbStairs2(10));
		//System.out.println(ClimbingStairs.climbStairs3(31));
		long end = System.currentTimeMillis();
		//System.out.println(end-start);
	}
}
