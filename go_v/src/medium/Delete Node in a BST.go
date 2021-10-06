package medium

// leetcode-0450 2021/3/20

func deleteNode(root *TreeNode, key int) *TreeNode {
	if root == nil {
		return root
	}
	if root.Val < key {
		root.Right = deleteNode(root.Right, key)
	} else if root.Val > key {
		root.Left = deleteNode(root.Left, key)
	} else {
		if root.Left == nil {
			return root.Right
		}
		if root.Right == nil {
			return root.Left
		}
		pt := root.Right
		for pt.Left != nil {
			pt = pt.Left
		}
		pt.Left = root.Left
		root = root.Right
	}
	return root
}
