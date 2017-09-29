package algorithms;


/**
 * 背包问题
 * @author Administrator
 *
 * @date 2017年2月12日
 */
public class Knapsack {
   /**
    * 
    * @param v 价值
    * @param w 重量
    * @param c 背包容量
    */
	public static void knaPsack(int[]value,int[] weight,int c){
		 int n = weight.length; 
	        int[] w = new int[n + 1];
	        int[] v = new int[n + 1];
	        for (int i = 1; i < n + 1; i++) {
	            w[i] = weight[i - 1];
	            v[i] = value[i - 1];
	        }

	        int[] values = new int[c + 1];
	        for (int i = 1; i < n + 1; i++) {
	            for (int t = c; t >= w[i]; t--) {
	                if (values[t] < values[t - w[i]] + v[i]) {
	                    values[t] = values[t - w[i]] + v[i];
	                }
	            }
	        }
	        System.out.println(values[c]);

	}
}
