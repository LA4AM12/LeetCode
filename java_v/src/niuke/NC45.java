package niuke;

import Offer.struct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : LA4AM12
 * @create : 2021-10-22 16:29:57
 * @description :
 */
public class NC45 {
	private ArrayList<Integer> list = new ArrayList<>();

	public int[][] threeOrders (TreeNode root) {
		// write code here
		int[][] ans = new int[3][];

		preOrder(root);
		ans[0] = list.stream().mapToInt(Integer::intValue).toArray();
		list.clear();
		inOrder(root);
		ans[1] = list.stream().mapToInt(Integer::intValue).toArray();
		list.clear();
		postOrder(root);
		ans[2] = list.stream().mapToInt(Integer::intValue).toArray();

		return ans;
	}

	private void preOrder(TreeNode root) {
		if (root == null) return;

		list.add(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	private void inOrder(TreeNode root) {
		if (root == null) return;

		inOrder(root.left);
		list.add(root.val);
		inOrder(root.right);
	}

	private void postOrder(TreeNode root) {
		if (root == null) return;

		postOrder(root.left);
		postOrder(root.right);
		list.add(root.val);
	}
}
