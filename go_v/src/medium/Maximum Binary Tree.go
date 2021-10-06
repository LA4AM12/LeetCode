package medium

import "math"

// leetcode-0654 2021/3/15

func constructMaximumBinaryTree(nums []int) *TreeNode {
	if len(nums) == 0{
		return nil
	}
	max := math.MinInt32
	var maxId int
	for id, n := range nums {
		if n > max {
			max = n
			maxId = id
		}
	}
	var root TreeNode
	root.Val = max
	root.Left = constructMaximumBinaryTree(nums[:maxId])
	root.Right = constructMaximumBinaryTree(nums[maxId+1:])
	return &root
}
