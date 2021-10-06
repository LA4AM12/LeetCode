package medium

// leetcode-0105 2021/3/15

//前序和中序
func buildTree1(preorder []int, inorder []int) *TreeNode {
	//base case
	if len(preorder) == 0 {
		return nil
	}

	root := TreeNode{Val: preorder[0]}
	var pivot int
	for id, n := range inorder {
		if n == preorder[0] {
			pivot = id
			break
		}
	}
	root.Left = buildTree1(preorder[1:pivot+1], inorder[:pivot])
	root.Right = buildTree1(preorder[pivot+1:], inorder[pivot+1:])
	return &root
}

//中序和后序
func buildTree(inorder []int, postorder []int) *TreeNode {
	//base case
	if len(inorder) == 0 {
		return nil
	}

	root := TreeNode{Val: postorder[len(postorder)-1]}
	var pivot int
	for id, n := range inorder {
		if n == postorder[len(postorder)-1] {
			pivot = id
			break
		}
	}
	root.Left = buildTree(inorder[:pivot], postorder[:pivot])
	root.Right = buildTree(inorder[pivot+1:], postorder[pivot:len(postorder)-1])
	return &root
}
