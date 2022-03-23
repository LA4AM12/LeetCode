package MonotonicStack

// leetcode-0084 2022/03/23

func largestRectangleArea(heights []int) (ans int) {
	// add sentinels
	heights = append(append([]int{0}, heights...), 0)
	// monotonic stack (record the idx)
	stack := make([]int, 1)

	for i := 1; i < len(heights); i++ {
		for heights[i] < heights[stack[len(stack)-1]] {
			height := heights[stack[len(stack)-1]]
			// pop
			stack = stack[:len(stack)-1]
			width := i - stack[len(stack)-1] - 1
			ans = max(ans, height*width)
		}
		// push
		stack = append(stack, i)
	}
	return ans
}

func max(args ...int) int {
	m := args[0]
	for _, i := range args {
		if i > m {
			m = i
		}
	}
	return m
}
