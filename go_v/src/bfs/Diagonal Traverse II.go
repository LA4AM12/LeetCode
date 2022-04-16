package bfs

import "math"

// leetcode-1424 2022/4/16

func findDiagonalOrder(nums [][]int) []int {
	dict := make(map[int][]int)

	var max int
	for i := len(nums) - 1; i >= 0; i-- {
		for j := 0; j < len(nums[i]); j++ {
			dict[i+j] = append(dict[i+j], nums[i][j])
			max = int(math.Max(float64(i+j), float64(max)))
		}
	}

	ans := make([]int, 0)
	for i := 0; i <= max; i++ {
		ans = append(ans, dict[i]...)
	}

	return ans
}
