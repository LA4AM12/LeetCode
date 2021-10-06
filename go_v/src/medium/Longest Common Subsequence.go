package medium

import (
	"math"
)

// leetcode-1143 2021/3/20

func longestCommonSubsequence(text1 string, text2 string) int {
	dp := make([]int,len(text2)+1)

	for i := 1; i < len(text1)+1; i++ {
		pre := 0
		for j := 1; j < len(text2)+1; j++ {
			temp := dp[j]           //dp[i-1][j]
			if text1[i-1] == text2[j-1] {
				dp[j] = pre + 1
			}else {
				dp[j] = int(math.Max(float64(dp[j]),float64(dp[j-1])))
			}
			pre = temp
		}
	}

	return dp[len(text2)]
}
