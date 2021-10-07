package dp;

import java.util.Arrays;

/**
 * @author : LA4AM12
 * @create : 2021-10-07 09:59:58
 */
public class Solution354 {
	public int maxEnvelopes(int[][] envelopes) {

		//w from low to high , h from high to low
		Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

		//the ans is LIS of h now
		int[] dp = new int[envelopes.length];

		dp[0] = 1;

		for (int i = 1; i < envelopes.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (envelopes[i][1] > envelopes[j][1]){
					dp[i] = Math.max(dp[i],dp[j]+1);
				}
			}
		}

		int ans = 1;
		for (int i = 1; i < dp.length; i++) {
			if (dp[i] > ans) ans = dp[i];
		}

		return ans;
	}
}
