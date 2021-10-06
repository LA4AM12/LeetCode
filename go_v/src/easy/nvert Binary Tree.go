package easy

// leetcode-0226 2021/3/14

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode}

func invertTree(root *TreeNode) *TreeNode {
	//交换左右子结点  前序
	if root == nil {
		return nil
	}
	temp := root.Left
	root.Left = root.Right
	root.Right = temp
	invertTree(root.Left)
	invertTree(root.Right)
	return root
}
