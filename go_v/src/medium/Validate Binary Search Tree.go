package medium

// leetcode-0098 2021/3/21

func isValidBST(root *TreeNode) bool {
	var pre *TreeNode //保存上一个指针

	var travel func(*TreeNode) bool

	travel = func(node *TreeNode) bool {
		if node == nil {
			return true
		}

		// 中序遍历  --  验证是否为递增顺序
		left := travel(node.Left)

		if pre != nil && node.Val <= pre.Val {
			return false
		}
		pre = node
		right := travel(node.Right)

		return left && right
	}

	return travel(root)
}
