package greedy

import "math"

// leetcode-0045 2021/05/12

func jump(nums []int) int {
	// 以最小的步数增加覆盖范围，覆盖范围一旦覆盖了终点，得到的就是最小步数！
	var curRange, nextRange int //当前覆盖的最远距离下标 & 下一步覆盖的最远距离下标
	var ans int

	for i := 0; i < len(nums)-1; i++ { // 只移动到 len(nums) - 2 的位置
		nextRange = int(math.Max(float64(i+nums[i]), float64(nextRange)))
		if i == curRange {
			curRange = nextRange
			ans++
		}
	}
	return ans
}
