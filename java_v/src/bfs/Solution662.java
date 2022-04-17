package bfs;

import Offer.struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : LA4AM12
 * @create : 2022-04-17 09:52:45
 * @description : Maximum Width of Binary Tree
 */
public class Solution662 {
	public int widthOfBinaryTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		LinkedList<Integer> index = new LinkedList<>();
		queue.offer(root);
		index.offer(0);

		int ans = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			ans = Math.max(index.peekLast() - index.peekFirst() + 1, ans);
			while (size-- > 0) {
				TreeNode node = queue.poll();
				Integer idx = index.poll();
				if (node.left != null) {
					queue.offer(node.left);
					index.offer(2 * idx + 1);
				}
				if (node.right != null) {
					queue.offer(node.right);
					index.offer(2 * idx + 2);
				}
			}
		}

		return ans;
	}
}
