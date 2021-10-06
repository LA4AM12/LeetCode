package dp;

/**
 * @author : LA4AM12
 * @create : 2021-10-06 11:12:13
 */
public class Solution72 {
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();

		// where dp[i][j] means the result of word1[:i] and word2[:j]
		int[] dp = new int[n + 1];

		for (int j = 1; j <= n ; j++) {
			dp[j] = j;
		}

		for (int i = 1; i <= m; i++) {
			//base case
			dp[0] = i;
			int pre = i - 1;
			for (int j = 1; j <= n; j++) {
				int temp = dp[j];
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[j] = pre;  // pre = dp[i-1][j-1]
				} else {
					// dp[i][j] = dp[i][j-1] + 1;   insert
					// dp[i][j] = dp[i-1][j] + 1;   delete
					// dp[i][j] = dp[i-1][j-1] + 1;  replace
					dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), pre) + 1;
				}

				pre = temp;
			}
		}
		return dp[n];
	}
}
