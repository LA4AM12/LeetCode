package dp;

/**
 * @author : LA4AM12
 * @create : 2021-10-07 10:47:24
 */
public class Solution1143 {
	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length(), n = text2.length();

		int[] dp = new int[n+1];

		for (int i = 1; i <= m; i++) {
			int pre = 0;
			for (int j = 1; j <= n; j++) {
				int temp = dp[j];
				if (text1.charAt(i-1) == text2.charAt(j-1)){
					dp[j] = pre + 1;
				}else {
					dp[j] = Math.max(dp[j],dp[j-1]);
				}
				pre = temp;
			}
		}

		return dp[n];
	}
}
