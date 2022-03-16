package dp

// leetcode-0139 2022/3/16

func wordBreak(s string, wordDict []string) bool {
	dict := make(map[string]bool)
	for _, v := range wordDict {
		dict[v] = true
	}

	dp := make([]bool, len(s)+1)
	dp[0] = true

	for i := 1; i <= len(s); i++ {
		for j := i - 1; j >= 0; j-- {
			if dp[j] && dict[s[j:i]] {
				dp[i] = true
				break
			}
		}
	}

	return dp[len(s)]
}
