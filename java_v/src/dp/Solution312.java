package dp;

import java.lang.reflect.Array;

/**
 * @author : LA4AM12
 * @create : 2021-10-20 18:30:24
 * @description : Burst Balloons
 */
public class Solution312 {
	public int maxCoins(int[] nums) {
		int n = nums.length;

		//add a dummy balloon at both side
		int[] a = new int[n + 2];
		System.arraycopy(nums, 0, a, 1, n);
		a[0] = a[a.length - 1] = 1;

		// dp[i][j] is the answer for range (i,j)
		int[][] dp = new int[n + 2][n + 2];

		for (int i = n; i >= 0; i--) {
			for (int j = i + 1; j < n + 2; j++) {
				//The kth balloon finally poke burst
				for (int k = i + 1; k < j; k++) {
					dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + a[i] * a[k] * a[j]);
				}
			}
		}

		return dp[0][n + 1];
	}
}
