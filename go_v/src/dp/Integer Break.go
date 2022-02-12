package dp

// leetcode-0343 2022/02/12

func integerBreak(n int) int {
	dp := make([]int, n+1)
	dp[2] = 1

	for i := 3; i <= n; i++ {
		for j := 1; j < i-1; j++ {
			// dp[i-j] * j : 拆分成2个数以上的情况
			// (i-j)*j : 拆分成2个数的情况
			dp[i] = max(dp[i], dp[i-j]*j, (i-j)*j)
		}
	}

	return dp[n]
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
