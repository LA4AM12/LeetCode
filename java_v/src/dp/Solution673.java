package dp;

import java.util.Arrays;

/**
 * @author : LA4AM12
 * @create : 2021-12-09 22:57:15
 * @description : Number of Longest Increasing Subsequence
 */
public class Solution673 {
	public int findNumberOfLIS(int[] nums) {
		int maxLen = 0;
		int ans = 0;
		int n = nums.length;

		// dp[i] 以 nums[i] 结尾的最长递增序列的长度
		int[] dp = new int[n];
		// count[i] 是以 nums[i] 结尾的最长递增序列的个数
		// *** count[i] = 满足 dp[j] + 1 = dp[i] 的 count[j] 之和
		int[] count = new int[n];

		//base case
		Arrays.fill(dp, 1);
		Arrays.fill(count, 1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						count[i] = count[j];  // 重置计数
					} else if (dp[i] == dp[j] + 1) {
						count[i] += count[j];
					}
				}
			}
			if (dp[i] > maxLen) {
				maxLen = dp[i];
				ans = count[i];
			} else if (dp[i] == maxLen) {
				ans += count[i];
			}
		}
		return ans;
	}
}
