package hard

// leetcode-0010 2021/5/19

func IsMatch(s string, p string) bool {
	m, n := len(s), len(p)
	dp := make([][]bool, m+1)
	for i, _ := range dp {
		dp[i] = make([]bool, n+1)
	}

	//定义dp[i][j]表示s 的前 i 个字符与 p 中的前 j 个字符是否能够匹配
	//base case
	dp[0][0] = true
	for i := 0; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if p[j-1] == '*' {
				//如果字符不相等只能匹配0个
				dp[i][j] = dp[i][j-2]
				//如果字符相等，可以进行匹配0个或多个
				//匹配0个。忽略掉p[j-1]和 p[j-2]这两个字符，取决于dp[i][j-2]
				//进行匹配，取决于dp[i-1][j]
				if i > 0 && (s[i-1] == p[j-2] || p[j-2]=='.') {
					dp[i][j] = dp[i][j] || dp[i-1][j]
				}
			} else if i > 0 {
				if p[j-1] == '.' {
					dp[i][j] = dp[i-1][j-1]
				} else {
					dp[i][j] = dp[i-1][j-1] && s[i-1] == p[j-1]
				}
			}
		}
	}

	return dp[m][n]
}
