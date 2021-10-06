package medium

import "math"

// leetcode-0712 2021/05/06

func minimumDeleteSum(s1 string, s2 string) int {
	//定义  dp[i][j]  存放 s1前i位 s2前j位 的最小删除和
	// dp[0][...] = s2的ascii和      dp[...][0] = s1的ascii和
	dp := make([][]int,len(s1)+1)
	for i, _ := range dp {
		dp[i] = make([]int,len(s2)+1)
	}

	//base case
	for i := 1; i <= len(s2); i++ {
		dp[0][i] = dp[0][i-1] + int(s2[i-1])
	}

	for i := 1; i <= len(s1); i++ {
		//base case
		dp[i][0] = dp[i-1][0] + int(s1[i-1])

		for j := 1; j <= len(s2); j++ {
			if s1[i-1] == s2[j-1] {
				dp[i][j] = dp[i-1][j-1]
			}else{
				// dp[i][j-1] + s2[j]   ---- 删除s2[j]
				// dp[i-1][j] + s1[i]   ---- 删除s1[i]
				dp[i][j] = int(math.Min(float64(dp[i][j-1] + int(s2[j-1])),float64(dp[i-1][j] + int(s1[i-1]))))
			}
		}

	}

	return dp[len(s1)][len(s2)]
}
