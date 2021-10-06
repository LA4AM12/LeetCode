package medium

// leetcode-0494 2021/4/19

//回溯
func findTargetSumWays1(nums []int, target int) int {
	var res int
	var backtrack func(int, int)

	backtrack = func(sum, cur int) {
		if cur == len(nums) {
			if sum == target {
				res++
			}
			return
		}
		backtrack(sum-nums[cur], cur+1)
		backtrack(sum+nums[cur], cur+1)
	}

	backtrack(0, 0)
	return res
}
