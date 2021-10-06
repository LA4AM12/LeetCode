package medium

import (
	"math"
)

// leetcode-0583 2021/4/30


func minDistance(word1 string, word2 string) int {
	dp := make([][]int,len(word1)+1)
	for i, _ := range dp {
		dp[i] = make([]int,len(word2)+1)
		dp[i][0] = i
		for j,_ := range dp[0] {
			dp[0][j] = j
		}
	}

	for i := 1; i <= len(word1); i++ {
		for j := 1; j <= len(word2); j++ {
			if word1[i-1] == word2[j-1] {
				dp[i][j] = dp[i-1][j-1]
			}else {
				dp[i][j] = int(math.Min(float64(dp[i-1][j]),float64(dp[i][j-1])))+1
			}
		}
	}

	return dp[len(word1)][len(word2)]
}