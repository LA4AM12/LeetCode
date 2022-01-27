package dfs

// leetcode-0538 2021/3/19

func convertBST(root *TreeNode) *TreeNode {
	var sum int
	var sumGreater func(*TreeNode)
	sumGreater = func(node *TreeNode) {
		if node == nil {
			return
		}
		sumGreater(node.Right)
		sum += node.Val
		node.Val = sum
		sumGreater(node.Left)
	}
	sumGreater(root)
	return root
}
