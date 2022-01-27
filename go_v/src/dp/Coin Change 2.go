package dp

// leetcode-0518 2021/05/07

func change(amount int, coins []int) int {
	//dp[i][j]   只使用前 i个硬币的面值，去凑到 j 所有的方案数

	dp := make([][]int, len(coins)+1)

	for i, _ := range dp {
		dp[i] = make([]int, amount+1)
		//base case
		dp[i][0] = 1 //唯一的凑法就是不用硬币
	}

	for i := 1; i <= len(coins); i++ {
		for j := 1; j <= amount; j++ {
			if j-coins[i-1] >= 0 {
				dp[i][j] = dp[i-1][j] + dp[i-1][j-coins[i-1]]
			} else {
				dp[i][j] = dp[i-1][j]
			}

		}
	}
	return dp[len(coins)][amount]
}
