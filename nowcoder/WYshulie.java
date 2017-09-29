package nowcoder;

import java.util.Scanner;

/**
 * 小易非常喜欢拥有以下性质的数列:
1、数列的长度为n
2、数列中的每个数都在1到k之间(包括1和k)
3、对于位置相邻的两个数A和B(A在B前),都满足(A <= B)或(A mod B != 0)(满足其一即可)
例如,当n = 4, k = 7
那么{1,7,7,2},它的长度是4,所有数字也在1到7范围内,并且满足第三条性质,所以小易是喜欢这个数列的
但是小易不喜欢{4,4,4,2}这个数列。小易给出n和k,希望你能帮他求出有多少个是他会喜欢的数列。
  输入包括两个整数n和k(1 ≤ n ≤ 10, 1 ≤ k ≤ 10^5)
  输出一个整数,即满足要求的数列个数,因为答案可能很大,输出对1,000,000,007取模的结果。


输入例子1:

2 2

输出例子1:
3
 *
 *@author {wqz}
 * 动态规划
 * 链接：https://www.nowcoder.com/questionTerminal/49375dd6a42d4230b0dc4ea5a2597a9b
来源：牛客网

dp[i][j]表示整个状态空间，其中i(1<=i<=n)表示数列的长度，j(1<=j<=k)表示数列长度为i且以数字j结尾。   递推关系有：dp[i][j] += dp[i-1][m] (1<=m<=k, 
并且(m,j)是个合法的数列)，但是直接按照递推关系，用三层for循环会超时。为此可以先将长度为i-1的合法数列求和(记为sum)。然后对于数列长度为i的每一个j，
求出数列长度为i-1时非法的序列个数（记为invalid）,即有state[i][j] = sum - invalid。
 * @date 2017年8月19日 上午9:33:00
 */
public class WYshulie {
    static final int mod = 1000000007;
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt(); 
			int k = in.nextInt();
			int[][] dp = new int[n+1][k+1];
			dp[0][1]=1;    //将初始状态设置为dp[0][1]，可以使dp[1][1...k]=1。比较好理解的做法是直接将dp[1][1...k]=1作为初始状态，然后从i=2开始递推
			for(int i=1; i<=n;i++){
				int sum =0;
				for(int j=1;j<=k;j++){
					sum =(sum+dp[i-1][j])%mod;
				}
				for(int j=1; j<=k;j++){
					int invalid = 0;
					int p=2;
					while(p*j<=k){
						invalid = (invalid+dp[i-1][p*j]) % mod;     //不符合数列，如果我们确定这个数列的第一个数是i,那么第二个数可以是1到k中除了是i的约数的任何数，用p*j来代表约数，AmodB=0的数
						p++;
					}
					dp[i][j] = (sum - invalid + mod) % mod;
				}
			}
			int sum =0;
			for(int i=1; i<=k; i++){
				sum = (sum+dp[n][i])%mod;
			}
			System.out.println(sum);
		}
		in.close();
	}
    public static void loveCount(int n,int k){
    	int[][] dp = new int[n+1][k+1];
    	for(int i=1; i<=k;i++){
    		dp[1][i]=1;
    	}
    	for (int i=2; i <=n; i++) {
    		int sum = 0;
    		int p=2;
			for(int j=1; j<=k; j++){
				if(p*j<=k){
					
				}
				 sum=(dp[i-1][j]+sum)%mod;
			}
		}
    }
}
