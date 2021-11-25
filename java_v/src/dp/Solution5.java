package dp;

/**
 * @author : LA4AM12
 * @create : 2021-11-25 10:45:30
 * @description : Longest Palindromic Substring
 */
public class Solution5 {
	public String longestPalindrome(String s) {
		int maxLength = 1, begin = 0;
		int n = s.length();

		// dp[i][j] = s[i:j] is LP ?
		boolean[][] dp = new boolean[n][n];

		// base case
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (j - i < 3)
						dp[i][j] = true;
					else
						dp[i][j] = dp[i + 1][j - 1];
				}

				if (dp[i][j]) {
					if (j - i + 1 > maxLength) {
						maxLength = j - i + 1;
						begin = i;
					}
				}
			}
		}

		return s.substring(begin, begin + maxLength);
	}
}
