package medium

// leetcode-0114 2021/3/14

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//右子树接到左子树的最右端 再用左子树覆盖右子树
func flatten(root *TreeNode) {
	if root == nil {
		return
	}
	if root.Left != nil {
		pt := root.Left
		for pt.Right != nil {
			pt = pt.Right
		}
		pt.Right = root.Right
		root.Right = root.Left
		root.Left = nil
	}
	flatten(root.Right)
}
