package bfs;

import Offer.struct.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : LA4AM12
 * @create : 2021-11-01 10:54:24
 * @description : Binary Tree Right Side View
 */
public class Solution199 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new LinkedList<>();
		if (root == null) return ans;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = null;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				node = queue.poll();
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			ans.add(node.val);
		}
		return ans;
	}
}
