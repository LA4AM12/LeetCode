package dfs

import "container/list"

// leetcode-0094 2021/12/23

func inorderTraversal(root *TreeNode) []int {
	ans := make([]int, 0)

	if root == nil {
		return ans
	}

	stack := list.New()
	cur := root

	for cur != nil || stack.Len() > 0 {
		if cur != nil {
			stack.PushFront(cur)
			cur = cur.Left
		} else {
			cur = stack.Remove(stack.Front()).(*TreeNode)
			ans = append(ans, cur.Val)
			cur = cur.Right
		}
	}

	return ans
}
