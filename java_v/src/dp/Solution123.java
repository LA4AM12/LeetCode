package dp;

/**
 * @author : LA4AM12
 * @create : 2021-10-19 18:11:04
 * @description : Best Time to Buy and Sell Stock III
 */
public class Solution123 {
	public int maxProfit(int[] prices) {
		/**
		 * dp[i][k][s]  :
		 * i -- first i days
		 * k -- already bought k times
		 * s -- zero for not holding
		 * dp[n][2][0] = dp[n-1][2][0]  |  dp[n-1][2][1] + prices[n]
		 * dp[n][2][1] = dp[n-1][2][1]  |  dp[n-1][1][0] - prices[n]
		 * dp[n][1][0] = dp[n-1][1][0]  |  dp[n-1][1][1] + prices[n]
		 * dp[n][1][1] = dp[n-1][1][1]  |  - prices[n]
		 *
		 */

		int n = prices.length;

		//base case
		int i_1_0 = 0;
		int i_1_1 = -prices[0];
		int i_2_0 = 0;
		int i_2_1 = -prices[0];

		for (int i = 1; i < n; i++) {
			i_2_0 = Math.max(i_2_0, i_2_1 + prices[i]);
			i_2_1 = Math.max(i_2_1, i_1_0 - prices[i]);
			i_1_0 = Math.max(i_1_0, i_1_1 + prices[i]);
			i_1_1 = Math.max(i_1_1, -prices[i]);
		}

		return i_2_0;
	}
}
