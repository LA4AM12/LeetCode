package dp

// leetcode-0096 2022/02/12

/**
[]    null
	n
[]	  null
*/

func numTrees(n int) int {
	dp := make([]int, n+1)
	dp[0] = 1 // null

	for i := 1; i <= n; i++ {
		for j := 0; j < i; j++ {
			dp[i] += dp[j] * dp[i-j-1]
		}
	}

	return dp[n]
}
