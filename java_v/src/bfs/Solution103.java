package bfs;

import Offer.struct.TreeNode;

import java.util.*;

/**
 * @author : LA4AM12
 * @create : 2021-10-25 11:19:15
 * @description : Binary Tree Zigzag Level Order Traversal
 */
public class Solution103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean fromLeft = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			Deque<Integer> level = new LinkedList<>();

			while (size-- > 0) {
				TreeNode node = queue.poll();
				if (fromLeft)
					level.offerLast(node.val);
				else
					level.offerFirst(node.val);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}

			res.add(new ArrayList<>(level));
			fromLeft = !fromLeft;
		}
		return res;
	}
}
