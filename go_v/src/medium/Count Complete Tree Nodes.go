package medium

import (
	"sort"
)

// leetcode-0222 2021/3/25


//二分查找  +  位运算
func countNodes(root *TreeNode) int {
	if root == nil {
		return 0
	}

	//计算出树的层数 从0开始
	var level int
	for node := root; node.Left != nil ; node=node.Left {
		level++
	}

	//节点个数区间  [2^level,2^(level+1))


	//二分法找出[0,n)区间内满足func为true的最小值
	return sort.Search(1<<(level+1), func(i int) bool {
		if i <= 1<<level{
			return false
		}

		//除首位为1，后面的0表示向左，1表示向右

		mask := 1 << (level - 1)
		node := root

		for node!=nil && mask > 0 {
			if i&mask > 0 {
				node = node.Right
			}else {
				node = node.Left
			}
			mask=mask>>1
		}

		return node == nil
	})-1
}
