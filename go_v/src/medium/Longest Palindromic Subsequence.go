package medium

import "math"

// leetcode-0516 2021/4/17

//func longestPalindromeSubseq(s string) int {
//	l := len(s)
//	dp := make([][]int,l)
//
//	for i := range dp {
//		dp[i]  = make([]int,l)
//		dp[i][i] = 1
//	}
//
//	//求 dp[0][l-1]
//	for i := l-2; i >= 0 ; i-- {
//		for j := i+1; j < l; j++ {
//			if s[i] == s[j] {
//				dp[i][j] = 2 + dp[i+1][j-1]
//			}else {
//				dp[i][j] = int(math.Max(float64(dp[i+1][j]),float64(dp[i][j-1])))
//			}
//		}
//	}
//	return dp[0][l-1]
//}


//状态压缩，2维dp打成1维
func longestPalindromeSubseq(s string) int {
	l := len(s)
	dp := make([]int,l)

	for i := range dp {
		dp[i] = 1
	}

	var temp,pre int
	for i := l-2; i >= 0 ; i-- {
		pre = 0
		for j := i+1; j < l; j++ {
			temp = dp[j]    //此时temp为dp[i+1][j]
			if s[i] == s[j] {
				dp[j] = pre + 2   //由于第二次循环中j++，pre相当于dp[i+1][j-1]
			}else {
				//dp[j-1]是上一个算出来的 为dp[i][j-1]
				dp[j] = int(math.Max(float64(dp[j]),float64(dp[j-1])))
			}
			pre = temp
		}
	}
	return dp[l-1]
}