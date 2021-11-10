package dfs;

import Offer.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : LA4AM12
 * @create : 2021-11-10 17:09:04
 * @description : Construct Binary Tree from Preorder and Inorder Traversal
 */
public class Solution105 {
	private int preOrderIndex = 0;
	private Map<Integer,Integer> inOrderIndex = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			inOrderIndex.put(inorder[i],i);
		}

		return toTree(preorder,0,inorder.length - 1);
	}

	private TreeNode toTree(int[] preOrder, int left, int right) {
		if (right < left) return null;

		int val = preOrder[preOrderIndex++];
		TreeNode root = new TreeNode(val);

		int in = inOrderIndex.get(val);
		root.left = toTree(preOrder,left,in-1);
		root.right = toTree(preOrder,in+1,right);

		return root;
	}
}
