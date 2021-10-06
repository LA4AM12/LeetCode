package medium

// leetcode-0503 2021/3/30

func nextGreaterElements(nums []int) []int {
	stack := make([]int, 0)
	ans := make([]int, len(nums))

	for index, n := range nums {
		for len(stack) != 0 && nums[stack[len(stack)-1]] < n {
			ans[stack[len(stack)-1]] = n
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, index)
	}
	for _, n := range nums {
		for nums[stack[len(stack)-1]] < n {
			ans[stack[len(stack)-1]] = n
			stack = stack[:len(stack)-1]
		}
	}
	for len(stack) != 0 {
		ans[stack[len(stack)-1]] = -1
		stack = stack[:len(stack)-1]
	}
	return ans
}
