package dp;

import java.util.Arrays;

/**
 * @author : LA4AM12
 * @create : 2021-10-06 13:12:28
 * @description : Longest Increasing Subsequence
 */
public class Solution300 {
	public int lengthOfLIS(int[] nums) {
		int ans = 0;
		int n = nums.length;

		//dp[i] denotes the lengthOfLIS end with nums[i]
		int[] dp = new int[n];

		//base case
		Arrays.fill(dp, 1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]){
					dp[i] = Math.max(dp[i],dp[j] + 1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}

		return ans;
	}
}
