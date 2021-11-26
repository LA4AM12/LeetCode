package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2021-11-26 17:01:30
 * @description : Generate Parentheses
 */
public class Solution22 {
	List<String> ans;
	char[] p;

	public List<String> generateParenthesis(int n) {
		p = new char[n * 2];
		ans = new ArrayList<>();
		backtrack(0, 0, n);
		return ans;
	}

	// keeping track of the number of opening and closing brackets we have placed so far.
	private void backtrack(int l, int r, int n) {
		if (r == n) {
			ans.add(new String(p));
			return;
		}
		int cur = l + r;

		// add '('
		if (l < n) {
			p[cur] = '(';
			backtrack(l + 1, r, n);
		}

		// backtrack, add ')' if it will remain a valid sequence
		if (l > r) {
			p[cur] = ')';
			backtrack(l, r + 1, n);
		}
	}
}
