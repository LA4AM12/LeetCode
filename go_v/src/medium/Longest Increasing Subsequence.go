package medium

import "math"

// leetcode-0300 2021/4/24


func lengthOfLIS(nums []int) (res int) {
	dp := make([]int,len(nums))
	dp[0] = 1

	for i := 1; i < len(nums); i++ {
		dp[i] = 1
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] {
				dp[i] = int(math.Max(float64(dp[i]),float64(dp[j]+1)))
			}
		}
	}
	for i := 0; i < len(nums); i++ {
		res = int(math.Max(float64(dp[i]),float64(res)))
	}
	return res
}