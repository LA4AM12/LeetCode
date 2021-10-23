package dp;

/**
 * @author : LA4AM12
 * @create : 2021-10-23 10:09:56
 * @description : House Robber II
 */
public class Solution213 {
	public int rob(int[] nums) {
		int n = nums.length;

		int dp0 = 0, dp1 = nums[0];

		//Not robbing the last house
		for (int i = 2; i < n; i++) {
			int dp2 = Math.max(dp1,dp0+nums[i-1]);
			dp0 = dp1;
			dp1 = dp2;
		}

		int temp = dp1;

		//Not robbing the first house
		dp0 = 0;
		dp1 = 0;
		for (int i = 2; i <= n; i++) {
			int dp2 = Math.max(dp1,dp0+nums[i-1]);
			dp0 = dp1;
			dp1 = dp2;
		}

		return Math.max(temp, dp1);
	}
}
