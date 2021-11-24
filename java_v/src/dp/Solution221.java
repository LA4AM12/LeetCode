package dp;

/**
 * @author : LA4AM12
 * @create : 2021-11-24 20:01:32
 * @description : Maximal Square
 */
public class Solution221 {
	public int maximalSquare(char[][] matrix) {
		int r = matrix.length, c = matrix[0].length;

		// dp(i,j) represents the side length of the maximum square
		// whose bottom right corner is the cell with index (i,j) in the original matrix.
		int[] dp = new int[c];
		int max = 0;

		for (int i = 0; i < r; i++) {
			int pre = 0;
			for (int j = 0; j < c; j++) {
				int temp = dp[j];    // dp[i-1][j]
				if (matrix[i][j] == '1') {
					if (i == 0 || j == 0)
						dp[j] = 1;
					else
						dp[j] = Math.min(pre, Math.min(dp[j - 1], dp[j])) + 1;
					max = Math.max(max, dp[j]);
				} else dp[j] = 0;
				pre = temp;
			}
		}

		return max * max;
	}
}
