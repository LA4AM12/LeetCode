package dp;

/**
 * @author : LA4AM12
 * @create : 2021-10-04 11:09:25
 * @description : Coin Change 2
 */

public class Solution518 {
	public int change(int amount, int[] coins) {
		//dp[i][j] = dp[i-1][j] + dp[i][j-coin]
		int[] dp = new int[amount + 1];

		//base case  dp[...][0] = 1
		dp[0] = 1;

        // combinations
		for (int coin : coins) {
			for (int j = 1; j <= amount; j++) {
				if (j - coin >= 0) {
					dp[j] += dp[j - coin];
				}
			}
		}
		return dp[amount];
	}
}
