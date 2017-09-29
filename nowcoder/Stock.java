package nowcoder;

/**
 * 
 * 

在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)
。给出一天中的股票变化序列，请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。

给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。
测试样例：

[10,22,5,75,65,80],6

返回：87
注：第i天卖出后可买入
 *正着来一遍，倒着来一遍
 *@author {wqz}
 *
 * @date 2017年8月29日 下午9:53:20
 */
public class Stock {

	    public static int maxProfit(int[] prices, int n) {
	    	//第i天之前的最大利益  
	        int[] preProfit = new int[n];  
	        //第i天之后的最大  
	        int[] postProfit = new int[n];  
	        //总的最大利润  
	        int max = Integer.MIN_VALUE;  
	          
	        //如果今天的价格减掉最小价格比截止到昨天的最大收益大，就用今天的价格减去最小价格，否则，用截止到昨天的最大收益  --最小买入价格的利润
	        int minBuy = prices[0];  
	        for(int i = 1;i<n;i++){  
	            minBuy = Math.min(minBuy, prices[i]);  
	            preProfit[i] = Math.max(preProfit[i-1], prices[i] - minBuy);  
	        }  
	        //如果最大价格减掉今天价格比明天以后买入的最大收益大，就用最大价格减掉今天价格，否则，用明天以后买入的最大收益  --最大卖出价格的利润
	        int maxSell = prices[n-1];  
	        for(int i = n-2;i>=0;i--){  
	            maxSell = Math.max(maxSell, prices[i]);  
	            postProfit[i] = Math.max(postProfit[i+1], maxSell-prices[i]);  
	        }  
	        //求出两次交易的和，与总的最大利润进行比较  
	        for(int i = 0;i<n;i++){  
	            max = Math.max(preProfit[i] + postProfit[i], max);  
	        }  
	        return max;  
	    }
	   public static int maxProfit2(int[] prices, int n) {
	    	    int firstBuyProfit=Integer.MIN_VALUE;
	    	    int firstSaleProfit=0;
	    	    int secondBuyProfit=Integer.MIN_VALUE;
	    	    int secondSaleProfit=0;
	    	    for (int i = 0; i < n; i++) {
	    	        firstBuyProfit=Math.max(firstBuyProfit, -prices[i]);
	    	        firstSaleProfit=Math.max(firstSaleProfit, firstBuyProfit+prices[i]);
	    	        secondBuyProfit=Math.max(secondBuyProfit, firstSaleProfit-prices[i]);  //手頭剩餘钱最大
	    	        secondSaleProfit=Math.max(secondSaleProfit, secondBuyProfit+prices[i]);
	    	    }
	    	    return secondSaleProfit;
	    	}
	    public static void main(String[] args) {
				int[] prices ={10,22,5,75,65,80};
				System.out.println(maxProfit2(prices,prices.length));
			}
}
