package dfs

// leetcode-0236 2021/3/24

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	//base case
	if root == nil {
		return nil
	}
	if root == p || root == q {
		return root
	}

	//post order
	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)

	if left != nil && right != nil {
		return root
	} else if left == nil && right == nil {
		return nil
	} else if right != nil {
		return right
	} else {
		return left
	}
}
