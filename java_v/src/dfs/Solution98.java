package dfs;

import Offer.struct.TreeNode;

/**
 * @author : LA4AM12
 * @create : 2021-11-24 19:28:12
 * @description : Validate Binary Search Tree
 */
public class Solution98 {

	// inorder
	private long  pre = Long.MIN_VALUE;

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		boolean left = isValidBST(root.left);

		if (root.val <= pre)
			return false;
		else
			pre = root.val;

		return left && isValidBST(root.right);
	}

}
