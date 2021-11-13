package dfs;

import Offer.struct.TreeNode;

/**
 * @author : LA4AM12
 * @create : 2021-11-13 10:13:54
 * @description : Binary Tree Maximum Path Sum
 */
public class Solution124 {
	private int maxPathSum;

	public int maxPathSum(TreeNode root) {
		maxPathSum = Integer.MIN_VALUE;
		dfs(root);
		return maxPathSum;
	}

	//返回当前子树能向父节点“提供”的最大路径和
	private int dfs(TreeNode root) {
		if (root == null) return 0;

		int left = dfs(root.left);
		int right = dfs(root.right);

		int provide = root.val + Math.max(left, right);

		//一个子树内部的最大路径和 包括当前根节点
		maxPathSum = Math.max(maxPathSum, root.val + left + right);

		return Math.max(provide, 0);
	}
}
