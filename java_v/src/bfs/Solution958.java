package bfs;

import Offer.struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : LA4AM12
 * @create : 2021-12-13 10:38:27
 * @description : Check Completeness of a Binary Tree
 */
public class Solution958 {
	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>() {{
			add(root);
		}};

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left != null) {
				queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
				else break;
			} else if (node.right != null)  // left == null
				return false;
			else break;  // left == right == null
		}

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left != null || node.right != null)
				return false;
		}
		return true;
	}
}
