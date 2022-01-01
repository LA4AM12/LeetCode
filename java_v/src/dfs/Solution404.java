package dfs;

import Offer.struct.TreeNode;

/**
 * @author : LA4AM12
 * @create : 2021-12-24 10:47:18
 * @description : Sum of Left Leaves
 */
public class Solution404 {
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null || root.left == null && root.right == null)
			return 0;

		int sum = 0;
		if (root.left != null && root.left.left == null && root.left.right == null)
			sum += root.left.val;
		return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}
}
