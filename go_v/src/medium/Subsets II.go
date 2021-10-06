package medium

import (
	"sort"
)

// leetcode-0090 2021/3/6

func SubsetsWithDup(nums []int) [][]int {
	res := make([][]int, 1)
	var pre,cur int
	sort.Ints(nums)
	for id, num := range nums {
		cur = len(res)   //当前数字开始往res里添加的位置
		for id2, set := range res {
			//如果当前数和前一个数相等 跳过
			if id > 0 && nums[id] == nums[id-1] && id2 < pre {
				continue
			}
			clone := make([]int, len(set), len(set)+1)
			copy(clone, set)
			clone = append(clone, num)
			res = append(res, clone)
		}
		pre = cur
	}
	return res
}

//dfs+回溯
func subsetsWithDup(nums []int) [][]int {
	n, res := len(nums), make([][]int, 0)
	sort.Ints(nums)
	var dfs func(int, []int)

	dfs = func(cur int, temp []int) {
		res = append(res, append([]int(nil), temp...))
		for i := cur; i < n; i++ {
			if i > cur && nums[i] == nums[i-1] { // skip
				continue
			}
			temp = append(temp, nums[i])
			dfs(i+1, temp)
			temp = temp[:len(temp)-1]
		}
	}
	dfs(0, []int{})
	return res
}
