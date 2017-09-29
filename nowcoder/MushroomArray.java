package nowcoder;

import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * 现在有两个好友A和B，住在一片长有蘑菇的由n＊m个方格组成的草地，A在(1,1),B在(n,m)。现在A想要拜访B，
 * 由于她只想去B的家，所以每次她只会走(i,j+1)或(i+1,j)这样的路线，在草地上有k个蘑菇种在格子里(多个蘑菇可能在同一方格),问：
 * A如果每一步随机选择的话(若她在边界上，则只有一种选择)，那么她不碰到蘑菇走到B的家的概率是多少？
输入描述:
第一行N，M，K(1 ≤ N,M ≤ 20, k ≤ 100),N,M为草地大小，接下来K行，每行两个整数x，y，代表(x,y)处有一个蘑菇。
输出描述:
输出一行，代表所求概率(保留到2位小数)
输入例子:
2 2 1
2 1
输出例子:
0.50
 * 
 *
 *@author Administrator
 *要使用动态规划，注意每个点的概率来源，第一行的点，如(1,3)的概率来源只有它左边点(1,2)的1/2，
//第n行的点如(n,3)，概率来源为(n,2)+(n-1,3)*1/2，因为(n,2)只能往右走，概率为1
 * @date 2017年6月13日 下午7:28:21
 */
public class MushroomArray {
    public static void main(String[] args) {
		    Scanner in = new Scanner(System.in);
		    while(in.hasNext()){
		    	int n = in.nextInt();
		    	int m = in.nextInt();
		    	int k = in.nextInt();
		    	//Map<Integer,Integer> taboo = new HashMap<Integer,Integer>();  //相同key会覆盖
		    	int[][] map = new int[n+1][m+1];    //加1从1开始
		    	for(int i=0;i<k;i++){
		    		int a = in.nextInt();
		    		int b = in.nextInt();
		    		map[a][b]=1;       
		    	}
		    	double[][] arr =new double[n+1][m+1];
				arr[1][1] = 1;  
			        for(int i=1; i<=n; ++i){ 
			            for(int j=1; j<=m; ++j){ 
			            	if(i==1 && j==1) continue;  
			                if(map[i][j]==1) arr[i][j]=0;
			                else{
			                	arr[i][j]=(j==m?1:0.5)*arr[i-1][j]+arr[i][j-1]*(i==n?1:0.5);
			                }
			            }  
			        }  
		    	DecimalFormat df = new DecimalFormat("0.00");
		    	System.out.println(df.format(arr[n][m]));
		    }
		    in.close();
	}
}
