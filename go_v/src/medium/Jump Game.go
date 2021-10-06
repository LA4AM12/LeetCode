package medium

// leetcode-0055 2021/05/11

func canJump(nums []int) bool {
	farthest := nums[0] //所能到达的最远的下标
	for i := 1; i < len(nums)-1; i++ {
		if i + nums[i] > farthest {
			farthest = i + nums[i]
		}
		if farthest == i { //其中有一个位置是0 并且只能到那里
			return false
		}
	}
	return true
}