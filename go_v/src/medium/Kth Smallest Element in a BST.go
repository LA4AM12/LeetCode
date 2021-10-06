package medium

// leetcode-0230 2021/3/18

func kthSmallest(root *TreeNode, k int) (res int) {
	var rank int
	var traverse func(*TreeNode)

	traverse = func(node *TreeNode) {
		if node == nil {
			return
		}
		traverse(node.Left)
		rank++
		if rank == k {
			res = node.Val
			return
		}
		traverse(node.Right)
	}

	traverse(root)
	return res
}
