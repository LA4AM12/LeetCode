package backtracking;

import Offer.struct.TreeNode;

import java.util.*;

/**
 * @author : LA4AM12
 * @create : 2021-12-05 10:03:09
 * @description : Path Sum II
 */
public class Solution113 {
	List<List<Integer>> ans = new ArrayList<>();
	Deque<Integer> path = new LinkedList<>();

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		dfs(root, targetSum);
		return ans;
	}

	private void dfs(TreeNode root, int targetSum) {
		if (root == null)
			return;

		// pre order dfs
		path.offerLast(root.val);
		targetSum -= root.val;
		// if reach the leaf
		if (root.left == null && root.right == null && targetSum == 0) {
			ans.add(new ArrayList<>(path));
		}
		dfs(root.left, targetSum);
		dfs(root.right, targetSum);
		path.pollLast();
	}
}
