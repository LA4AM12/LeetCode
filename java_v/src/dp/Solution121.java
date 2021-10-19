package dp;

/**
 * @author : LA4AM12
 * @create : 2021-10-19 16:18:38
 * @description : Best Time to Buy and Sell Stock
 */
public class Solution121 {
	public int maxProfit(int[] prices) {

		// dp[i][0] is the maximum profit for the first i days
		int n = prices.length;

		//base case i = 0
		//0 : no holding   1 : holding
		int dp_i_0 = 0,dp_i_1= Integer.MIN_VALUE;

		for (int i = 1; i <= n; i++) {
			dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i-1]);
			dp_i_1 = Math.max(dp_i_1,-prices[i-1]);
		}

		return dp_i_0;
	}
}
