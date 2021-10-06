package easy

// leetcode-0026 2021/4/12

func removeDuplicates(nums []int) int {
	slow, fast := 0, 0
	for fast < len(nums) {
		if nums[fast] == nums[slow] {
			fast++
			continue
		}
		slow++
		nums[slow] = nums[fast]
	}
	return slow + 1
}
