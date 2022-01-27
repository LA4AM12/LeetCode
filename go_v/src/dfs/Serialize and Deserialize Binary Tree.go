package dfs

import (
	"strconv"
	"strings"
)

// leetcode-0297 2021/3/22

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type Codec struct {
	list []string
}

func Constructor1() Codec {
	return Codec{}
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) (s string) {
	if root == nil {
		s += "#,"
	} else {
		s += strconv.Itoa(root.Val) + ","
		s += this.serialize(root.Left)
		s += this.serialize(root.Right)
	}
	return s
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
	this.list = strings.Split(data, ",")
	var generate func() *TreeNode
	generate = func() *TreeNode {
		if this.list[0] == "#" {
			this.list = this.list[1:]
			return nil
		} else {
			node := TreeNode{}
			node.Val, _ = strconv.Atoi(this.list[0])
			this.list = this.list[1:]
			node.Left = generate()
			node.Right = generate()
			return &node
		}
	}
	return generate()
}
