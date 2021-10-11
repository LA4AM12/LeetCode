package dp;

/**
 * @author : LA4AM12
 * @create : 2021-10-11 12:12:55
 * @description : Dungeon Game
 */
public class Solution174 {
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length, n = dungeon[0].length;

		// dp[i][j] is the minimum hp from dungeon[i][j] to the end
		int[] dp = new int[n];

		dp[n - 1] = dungeon[m - 1][n - 1] < 0 ? 1 - dungeon[m - 1][n - 1] : 1;

		//base case
		for (int j = n - 2; j >= 0; j--) {
			dp[j] = dp[j + 1] - dungeon[m - 1][j];
			if (dp[j] <= 0) dp[j] = 1;
		}

		for (int i = m - 2; i >= 0; i--) {
			//base case
			dp[n - 1] = dp[n - 1] - dungeon[i][n - 1];
			if (dp[n - 1] <= 0) dp[n - 1] = 1;

			for (int j = n - 2; j >= 0; j--) {
				int minimumHp = Math.min(dp[j], dp[j + 1]);
				dp[j] = minimumHp - dungeon[i][j];
				if (dp[j] <= 0) dp[j] = 1;
			}
		}

		return dp[0];
	}
}
