package dp;

/**
 * @author : LA4AM12
 * @create : 2021-10-20 19:16:05
 * @description : Best Time to Buy and Sell Stock IV
 */

// Refer to question 123
public class Solution188 {
	public int maxProfit(int k, int[] prices) {
		int n = prices.length;
		if (n == 0) return 0;
		int[][] dp = new int[k + 1][2];

		for (int i = 1; i <= k; i++) {
			dp[i][1] = -prices[0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
				dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
			}
		}

		return dp[k][0];
	}
}
