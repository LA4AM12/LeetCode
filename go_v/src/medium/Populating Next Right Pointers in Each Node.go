package medium
// leetcode-0116 2021/3/14

type Node struct {
    Val int
    Left *Node
    Right *Node
    Next *Node
}


func connect(root *Node) *Node {
	//辅助函数  用于连接两个结点
	var connectTwoNodes func(node1,node2 *Node)
	connectTwoNodes = func(node1, node2 *Node) {
		if node1 == nil || node2 == nil {
			return
		}
		node1.Next = node2
		connectTwoNodes(node1.Left,node1.Right)
		connectTwoNodes(node2.Left,node2.Right)
		connectTwoNodes(node1.Right,node2.Left)
	}
	if root != nil {
		connectTwoNodes(root.Left,root.Right)
	}
	return root
}