package dfs;

import Offer.struct.TreeNode;

/**
 * @author : LA4AM12
 * @create : 2021-11-29 09:48:36
 * @description : Balanced Binary Tree
 */
public class Solution110 {
	public boolean isBalanced(TreeNode root) {
		return dfs(root) != -1;
	}

	// postorder
	private int dfs(TreeNode root) {
		if (root == null)
			return 0;
		int left = dfs(root.left);
		// cut
		if (left == -1) return -1;

		int right = dfs(root.right);
		if (right == -1) return -1;

		return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
	}
}
