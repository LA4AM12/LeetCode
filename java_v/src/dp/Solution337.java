package dp;

import Offer.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : LA4AM12
 * @create : 2021-10-23 10:52:07
 * @description : House Robber III
 */
public class Solution337 {
	private Map<TreeNode,Integer> memo = new HashMap<>();
	public int rob(TreeNode root) {
		if (root == null)
			return 0;
		//rob or not ?
		if (!memo.containsKey(root)){
			int rob = root.val +
					(root.left == null?0:rob(root.left.left)+rob(root.left.right)) +
					(root.right == null?0:rob(root.right.left)+rob(root.right.right));
			int not_rob = rob(root.left) + rob(root.right);

			memo.put(root, Math.max(rob,not_rob));
		}

		return memo.get(root);
	}
}
