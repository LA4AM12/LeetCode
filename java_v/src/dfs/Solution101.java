package dfs;

import Offer.struct.TreeNode;

/**
 * @author : LA4AM12
 * @create : 2021-11-30 11:03:50
 * @description : Symmetric Tree
 */
public class Solution101 {
	public boolean isSymmetric(TreeNode root) {
		return root == null || dfs(root.left, root.right);
	}

	private boolean dfs(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 == null || node2 == null)
			return false;

		return node1.val == node2.val && dfs(node1.right, node2.left) && dfs(node1.left, node2.right);
	}
}
