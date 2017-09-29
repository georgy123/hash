package nowcoder;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MushroomArray2 {
	    public static Scanner input = new Scanner(System.in);
	    public static int n, m, k;
	    public static boolean[][] map;
	    public static void main(String[] args)
	    {
	        while (input.hasNext())
	        {
	            n = input.nextInt();
	            m = input.nextInt();
	            k = input.nextInt();           
	            map = new boolean[n][m];
	             
	            int x, y;           
	            for (int i = 0; i < k; i++)
	            {
	                x = input.nextInt();
	                y = input.nextInt();
	                map[x - 1][y - 1] = true;
	            }
	            int count=0;
		    	for (int i = 0; i <map.length; i++) {
					for (int j = 0; j <map[i].length; j++) {
						if(map[i][j]) count++;
					}
				}
		    	System.out.println(count);
	            double[][] dp = new double[n][m];
	            dp[0][0] = 1;
	            for (int i = 0; i < n; i++)
	            {
	                for (int j = 0; j < m; j++)
	                {
	                    if (i == 0 && j == 0)  continue;
	                     
	                    if (map[i][j])
	                    {
	                        dp[i][j] = 0;
	                    }
	                    else
	                    {
	                        if (i == 0 && j > 0)
	                        {
	                            dp[i][j] = dp[i][j - 1] * (n > 1 ? 0.5 : 1);
	                        }
	                        else if (j == 0 && i > 0)
	                        {
	                            dp[i][j] = dp[i - 1][j] * (m > 1 ? 0.5 : 1);
	                        }
	                        else if (j > 0 && i > 0)
	                        {
	                            dp[i][j] = (i == n - 1 ? 1 : 0.5) * dp[i][j - 1] + (j == m - 1 ? 1 : 0.5) * dp[i - 1][j];
	                        }
	                    }
	                }
	            }
	             
	            System.out.println(new DecimalFormat("0.00").format(dp[n - 1][m - 1]));
	        }
	    }
}
