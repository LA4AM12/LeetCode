package medium

import (
	"math"
)

// leetcode-0322 2021/4/13

func coinChange(coins []int, amount int) int {
	//dp table
	//dp[i]表示amount为i时需要的最少硬币数
	dp := make([]int, amount+1)
	dp[0] = 0

	for i := 1; i <= amount; i++ {
		//初始化
		dp[i] = amount + 1
		for _,coin := range coins {
			if coin > i || dp[i-coin] == -1 {
				continue
			}
			dp[i] = int(math.Min(float64(dp[i]), float64(dp[i-coin]+1)))
		}
		if dp[i] == amount+1 {
			dp[i] = -1
		}
	}
	return dp[amount]
}
