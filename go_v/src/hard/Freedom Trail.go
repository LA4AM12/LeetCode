package hard

import "math"

// leetcode-0514 2021/05/16

func findRotateSteps(ring string, key string) int {
	const inf = math.MaxInt32
	n,m := len(ring),len(key)

	//记录字符在ring中的位置
	pos := [26][]int{}
	for i, c := range ring {
		pos[c-'a'] = append(pos[c-'a'],i)
	}

	//dp[i][j]对于key的前i个字符，最后ring的第j个字符在12点钟方向的结果
	dp := make([][]int,m)
	for i := range dp {
		dp[i] = make([]int,n)
		//base case
		for j := range dp[i] {
			dp[i][j] = inf
		}
	}
	//base case  完成第一个字符
	for _, p := range pos[key[0]-'a'] {
		dp[0][p] = min(p, n-p) + 1
	}

	for i := 1; i < m; i++ {
		//j : key[i]在ring中的下标
		for _, j := range pos[key[i]-'a'] {
			//k : key[i-1]在ring中的下标
			for _, k := range pos[key[i-1]-'a'] {
				dp[i][j] = min(dp[i][j],(dp[i-1][k]+min(abs(j-k),n-abs(j-k)))+1)
			}
		}
	}
	return min(dp[m-1]...)
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}