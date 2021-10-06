package dp;

import java.util.Arrays;

/**
 * @author : LA4AM12
 * @create : 2021-10-06 13:12:28
 */
public class Solution300 {
	public int lengthOfLIS(int[] nums) {
		int n = nums.length;

		//dp[i] denotes the lengthOfLIS end with nums[i]
		int[] dp = new int[n];

		//base case
		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]){
					dp[i] = Math.max(dp[i],dp[j] + 1);
				}
			}
		}

		int ans = 1;

		for (int i : dp) {
			if (i > ans)
				ans = i;
		}

		return ans;
	}
}
