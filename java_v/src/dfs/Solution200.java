package dfs;

/**
 * @author : LA4AM12
 * @create : 2021-11-02 18:41:33
 * @description : Number of Islands
 */
public class Solution200 {
	public int numIslands(char[][] grid) {
		int m = grid.length, n = grid[0].length;
		int ans = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					ans++;
					dfs(grid, i, j);
				}
			}
		}
		return ans;
	}

	// set to '0' while it connect to '1'
	private void dfs(char[][] grid, int i, int j) {
		if (i < grid.length
				&& i >= 0
				&& j >= 0
				&& j < grid[0].length
				&& grid[i][j] == '1') {
			grid[i][j] = '0';
			// up
			dfs(grid, i - 1, j);
			// right
			dfs(grid, i, j + 1);
			// down
			dfs(grid, i + 1, j);
			// left
			dfs(grid, i, j - 1);
		}
	}
}
