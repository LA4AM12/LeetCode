package math;

/**
 * @author : LA4AM12
 * @create : 2021-12-03 21:05:05
 * @description : Rotate Image
 */
public class Solution48 {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		// (i, j) --> (j, n - i - 1)
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = temp;
			}
		}
	}
}
