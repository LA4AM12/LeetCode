package TowPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2021-11-03 19:32:52
 * @description : Spiral Matrix
 */
public class Solution54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;

		int top = 0, bottom = m - 1;
		int left = 0, right = n - 1;

		List<Integer> ans = new ArrayList<>(m * n);

		while (true) {
			for (int i = left; i <= right; i++)
				ans.add(matrix[top][i]);
			if (bottom < ++top) break;

			for (int i = top; i <= bottom; i++)
				ans.add(matrix[i][right]);
			if (--right < left) break;

			for (int i = right; i >= left; i--)
				ans.add(matrix[bottom][i]);
			if (--bottom < top) break;

			for (int i = bottom; i >= top; i--)
				ans.add(matrix[i][left]);
			if (right < ++left) break;
		}

		return ans;
	}
}
