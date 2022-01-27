package SlidingWindow

// leetcode-0239 2021/4/1

func maxSlidingWindow(nums []int, k int) []int {
	window := make([]int, 0)
	ans := make([]int, len(nums)-k+1)
	var push = func(n int) {
		for len(window) != 0 && window[len(window)-1] < n {
			window = window[:len(window)-1]
		}
		window = append(window, n)
	}
	var pop = func(n int) {
		if window[0] == n {
			window = window[1:]
		}
	}

	//填满前n-1个
	for i := 0; i < k-1; i++ {
		push(nums[i])
	}

	for i := k - 1; i < len(nums); i++ {
		//进入一个新的元素
		push(nums[i])

		//取最大值
		ans[i-k+1] = window[0]

		//出去一个元素
		pop(nums[i-k+1])
	}

	return ans
}
