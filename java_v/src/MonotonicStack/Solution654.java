package MonotonicStack;

import Offer.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : LA4AM12
 * @create : 2021-12-25 16:57:09
 * @description : Maximum Binary Tree
 */
public class Solution654 {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		Deque<TreeNode> stack = new LinkedList<>();

		stack.push(new TreeNode(nums[0]));

		for (int i = 1; i < nums.length; i++) {
			TreeNode node = new TreeNode(nums[i]);
			while (!stack.isEmpty() && stack.peek().val < nums[i]) {
				node.left = stack.pop();
			}
			if (!stack.isEmpty())
				stack.peek().right = node;
			stack.push(node);
		}

		return stack.peekLast();
	}
}
