package medium

import "math"

// leetcode-0098 2021/3/21

func isValidBST(root *TreeNode) bool {
	var check func(*TreeNode, int, int) bool
	check = func(node *TreeNode, min int, max int) bool {
		if node == nil {
			return true
		}
		if node.Val > min && node.Val < max {
			return check(node.Left, min, node.Val) && check(node.Right, node.Val, max)
		} else {
			return false
		}
	}
	return check(root, math.MinInt64, math.MaxInt64)
}
