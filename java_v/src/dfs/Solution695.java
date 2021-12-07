package dfs;

/**
 * @author : LA4AM12
 * @create : 2021-12-07 22:49:59
 * @description : Max Area of Island
 */
public class Solution695 {
	public int maxAreaOfIsland(int[][] grid) {
		int m = grid.length, n = grid[0].length;

		int ans = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				ans = Math.max(ans, dfs(grid, i, j));
			}
		}
		return ans;
	}

	private int dfs(int[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
		grid[i][j] = 0;
		return dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1) + 1;
	}
}
