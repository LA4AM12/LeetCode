package dfs

import (
	"strconv"
)

// leetcode-0652 2021/3/17

//序列化二叉树  后序遍历
func findDuplicateSubtrees(root *TreeNode) (ans []*TreeNode) {
	subTrees := make(map[string]int)

	var traverse func(root *TreeNode) string

	traverse = func(root *TreeNode) string {
		if root == nil {
			return "#"
		}
		left := traverse(root.Left)
		right := traverse(root.Right)
		res := left + "," + right + "," + strconv.Itoa(root.Val)
		subTrees[res]++
		if subTrees[res] == 2 {
			ans = append(ans, root)
		}
		return res
	}
	traverse(root)
	return ans
}
