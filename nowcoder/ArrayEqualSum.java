package nowcoder;

import java.util.Scanner;
/**
 * 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
输入描述:
输入为两行:
第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
第二行为n个正整数A[i](32位整数)，以空格隔开。
输出描述:
输出所求的方案数
示例1
输入
5 15
5 5 10 2 3
输出
4
 * 动态规划先画出一张二维表，求边缘值找规律，不能用生成函数，因为元素不可重复
 *
 *@author {wqz}
 *
 * @date 2017年8月25日 下午3:08:40
 */
public class ArrayEqualSum {
	public static void main(String[] args) {
		// Scanner sc=new Scanner(System.in);
		// while(sc.hasNext()){
		// int n=sc.nextInt();
		// int sum=sc.nextInt();
		// int[] A=new int[n+1];
		// long[] d=new long[sum+1];
		//// for(int i=1;i<=n;i++){
		//// A[i]=sc.nextInt();
		//// }
		// d[0]=1; //和为0的情况只有一种就是不放
		// for(int i=1;i<=n;i++){
		// A[i]=sc.nextInt();
		// for(int j=sum;j>=A[i];j--){
		// d[j]=d[j]+d[j-A[i]];
		// }
		// }
		// System.out.print(d[sum]);
		// }
		Scanner input = new Scanner(System.in);
		//while (input.hasNext()) {
			//int n = input.nextInt();
			//int m = input.nextInt();
		    int n =5;
		    int m =15;
			int[] arr = {5,5,10,2,3};
//			for (int i = 0; i < n; i++) {
//				arr[i] = input.nextInt();
//			}
			long[][] dp = new long[n][m + 1];
			dp[0][0] = 1;
			if (arr[0] <= m) {
				dp[0][arr[0]] = 1;
			}
			for (int i = 1; i < n; i++) {
				for (int j = 0; j <=m; j++) {
					if(j<arr[i]){
						//dp[i][j]+=dp[i-1][j];
						dp[i][j]=dp[i-1][j];   //这两个效果一样，dp[i][j]表示用前i个值组成和为j的方案个数
					}else{
						//dp[i][j]+=dp[i-1][j-arr[i]]+dp[i-1][j];
						dp[i][j]=dp[i-1][j-arr[i]]+dp[i-1][j];
					}
				}
			}
			for (int i = 0; i < n; i++) {
				System.out.println();
				for (int j = 0; j <=m; j++) {
					System.out.print(dp[i][j]+",");
				}
			}
			System.out.println(dp[n-1][m]);
		//}
	}
}
