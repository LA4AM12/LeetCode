package dp;

/**
 * @author : LA4AM12
 * @create : 2021-10-07 11:01:59
 */
public class Solution583 {
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();

		int[] dp = new int[n + 1];

		//base case
		for (int j = 1; j <= n; j++) {
			dp[j] = j;
		}

		for (int i = 1; i <= m; i++) {
			dp[0] = i;
			int pre = i - 1;
			for (int j = 1; j <= n; j++) {
				int temp = dp[j];
				if (word1.charAt(i-1) == word2.charAt(j-1)){
					dp[j] = pre;
				}else {
					//delete word1 or delete word2
					dp[j] = Math.min(dp[j-1],dp[j]) + 1;
				}
				pre = temp;
			}
		}

		return dp[n];
	}
}
