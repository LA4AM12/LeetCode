package dp;

/**
 * @author : LA4AM12
 * @create : 2021-10-10 09:40:55
 * @description : Minimum Path Sum
 */
public class Solution64 {
	public int minPathSum(int[][] grid) {
		// dp[i][j] is the min Path sum from [i][j] to the destination
		int m = grid.length, n = grid[0].length;
		int[][] dp = new int[m][n];

		//base case
		dp[m-1][n-1] = grid[m-1][n-1];

		for (int i = m-2; i >= 0; i--) {
			dp[i][n-1] = dp[i+1][n-1] + grid[i][n-1];
		}

		for (int j = n-2; j >= 0; j--) {
			dp[m-1][j] = dp[m-1][j+1] + grid[m-1][j];
		}

		for (int i = m-2; i >= 0; i--) {
			for (int j = n-2; j >= 0; j--) {
				dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]) + grid[i][j];
			}
		}

		return dp[0][0];
	}
}
