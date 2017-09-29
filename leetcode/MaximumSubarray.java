package leetcode;
/**
 * 求最大字段和
 * 
 *b[j]=max{b[j-1]+a[j],a[j]} 递归式
 *@author {wqz}
 *
 * @date 2017年7月23日 上午10:18:55
 */
public class MaximumSubarray {
     
	public int maxSubArray(int[] nums) {
        int b =0;
        int sum=Integer.MIN_VALUE;   //sum不取0可能数组中全取负数，0可能就变成最大的了
        for (int i = 0; i < nums.length; i++) {
			if(b<0) b=nums[i];
			else b+=nums[i];
			if(sum<b) sum=b;
		}
        return sum;
     }
	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
	}
}
