package dp;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : LA4AM12
 * @create : 2021-11-09 14:09:53
 * @description : Longest Valid Parentheses
 */
public class Solution32 {
	public int longestValidParentheses(String s) {
		int len = s.length();
		int ans = 0;

		//dp[i] is the ans of substring of s end of s[i]
		int[] dp = new int[len];

		for (int i = 1; i < len; i++) {
			// i - 1 - dp[i - 1] symmetric to the current ')'
			if (s.charAt(i) == ')' && i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
				int pre = i - 2 - dp[i - 1] >= 0 ? dp[i - 2 - dp[i - 1]] : 0;
				dp[i] = dp[i - 1] + 2 + pre;
				ans = Math.max(ans, dp[i]);
			}
		}
		return ans;
	}
}
