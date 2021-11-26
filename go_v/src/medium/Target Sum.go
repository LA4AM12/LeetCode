package medium

// leetcode-0494 2021/4/19

func findTargetSumWays(nums []int, target int) int {
	var res int
	var backtrack func(cur, sum int)

	backtrack = func(cur, sum int) {
		if cur == len(nums) {
			if sum == target {
				res++
			}
			return
		}
		backtrack(cur+1, sum+nums[cur])
		backtrack(cur+1, sum-nums[cur])
	}

	backtrack(0, 0)
	return res
}
