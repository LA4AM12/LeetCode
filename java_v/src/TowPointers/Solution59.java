package TowPointers;

/**
 * @author : LA4AM12
 * @create : 2021-12-15 20:39:27
 * @description : Spiral Matrix II
 */
public class Solution59 {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int num = 1;

		int u = 0, b = n - 1;
		int l = 0, r = n - 1;

		while (true) {
			for (int i = l; i <= r; i++)
				matrix[u][i] = num++;
			if (++u > b) break;

			for (int i = u; i <= b; i++)
				matrix[i][r] = num++;
			if (--r < l) break;

			for (int i = r; i >= l; i--)
				matrix[b][i] = num++;
			if (--b < u) break;

			for (int i = b; i >= u; i--)
				matrix[i][l] = num++;
			if (++l > r) break;
		}

		return matrix;
	}
}
