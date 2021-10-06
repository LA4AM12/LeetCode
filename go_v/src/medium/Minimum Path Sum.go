package medium

import "math"

// leetcode-0064 2021/05/14

func minPathSum(grid [][]int) int {
	//   m × n
	m,n := len(grid),len(grid[0])
	dp := make([][]int,m)

	for i := range dp {
		dp[i] = make([]int,n)
	}

	//base case
	dp[0][0] = grid[0][0]
	for i := 1; i < m; i++ {
		dp[i][0] = dp[i-1][0] + grid[i][0]
	}
	for i := 1; i < n; i++ {
		dp[0][i] = dp[0][i-1] + grid[0][i]
	}

	//dp[i][j]  :  起点到grid[i][j]的最小距离和
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			dp[i][j] = int(math.Min(float64(dp[i-1][j]),float64(dp[i][j-1]))) + grid[i][j]
		}
	}

	return dp[m-1][n-1]
}
