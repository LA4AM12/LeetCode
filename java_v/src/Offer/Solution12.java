package Offer;

/**
 * @author : LA4AM12
 * @create : 2021-11-30 09:49:26
 * @description : Word Search
 */

public class Solution12 {
	public boolean exist(char[][] board, String word) {
		char[] chars = word.toCharArray();

		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(board, chars, i, j, 0))
					return true;
			}
		}

		return false;
	}

	private boolean dfs(char[][] board, char[] chars, int i, int j, int k) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != chars[k])
			return false;
		if (k == chars.length - 1)
			return true;

		board[i][j] = '\0';
		boolean res = dfs(board, chars, i + 1, j, k + 1) || dfs(board, chars, i - 1, j, k + 1) ||
				dfs(board, chars, i, j + 1, k + 1) || dfs(board, chars, i, j - 1, k + 1);
		board[i][j] = chars[k];
		return res;
	}
}
