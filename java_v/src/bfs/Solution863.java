package bfs;

import Offer.struct.TreeNode;

import java.util.*;

/**
 * @author : LA4AM12
 * @create : 2022-02-12 11:09:25
 * @description : All Nodes Distance K in Binary Tree
 */
public class Solution863 {
	// Annotate Parent
	private Map<TreeNode, TreeNode> parent = new HashMap<>();

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		Queue<TreeNode> queue = new LinkedList<>() {{add(target);}};
		Set<TreeNode> seen = new HashSet<>() {{add(target);add(null);}};
		mapParent(root, null);

		while (k-- > 0) {
			int size = queue.size();
			while (size-- > 0) {
				TreeNode node = queue.remove();
				if (!seen.contains(node.left)) {
					queue.add(node.left);
					seen.add(node.left);
				}
				if (!seen.contains(node.right)) {
					queue.add(node.right);
					seen.add(node.right);
				}
				if (!seen.contains(parent.getOrDefault(node, null))) {
					queue.add(parent.get(node));
					seen.add(parent.get(node));
				}
			}
		}
		List<Integer> ans = new LinkedList<>();
		queue.forEach(o -> ans.add(o.val));
		return ans;
	}

	private void mapParent(TreeNode n, TreeNode p) {
		if (n == null) return;
		parent.put(n, p);
		mapParent(n.left, n);
		mapParent(n.right, n);
	}
}
