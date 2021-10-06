package hard

// leetcode-0072 2021/4/16

func minDistance(word1 string, word2 string) int {
	//创建一个dp table
	dp := make([][]int, len(word1)+1)
	for i := range dp {
		dp[i] = make([]int, len(word2)+1)
	}
	//base case
	for i := 0; i <= len(word1); i++ {
		dp[i][0] = i
	}
	for i := 0; i <= len(word2); i++ {
		dp[0][i] = i
	}

	//自下而上
	for i := 1; i <= len(word1); i++ {
		for j := 1; j <= len(word2); j++ {
			if word1[i-1] == word2[j-1] {
				dp[i][j] = dp[i-1][j-1] //skip
			} else {
				dp[i][j] = min(
					dp[i-1][j], //delete
					dp[i][j-1], //insert
					dp[i-1][j-1]) + 1 //replace
			}
		}
	}
	return dp[len(word1)][len(word2)]
}

func min(args ...int) int {
	m := args[0]
	for _, i := range args {
		if i < m {
			m = i
		}
	}
	return m
}
