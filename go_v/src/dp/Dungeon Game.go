package dp

// leetcode-0174 2021/05/15

//从右下开始往左上状态转移
// dp[i][j] 表示 从dungeon[i][j]开始到终点所需要的最小初始值

func calculateMinimumHP(dungeon [][]int) int {
	m, n := len(dungeon), len(dungeon[0])
	dp := make([][]int, m)

	for i, _ := range dp {
		dp[i] = make([]int, n)
	}

	//base case
	dp[m-1][n-1] = max1(1-dungeon[m-1][n-1], 1)
	for i := m - 2; i >= 0; i-- {
		dp[i][n-1] = max1(dp[i+1][n-1]-dungeon[i][n-1], 1)
	}
	for j := n - 2; j >= 0; j-- {
		dp[m-1][j] = max1(dp[m-1][j+1]-dungeon[m-1][j], 1)
	}

	//dp[i][j] = max( min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j] , 1 )
	for i := m - 2; i >= 0; i-- {
		for j := n - 2; j >= 0; j-- {
			dp[i][j] = max1(min1(dp[i+1][j], dp[i][j+1])-dungeon[i][j], 1)
		}
	}
	return dp[0][0]
}

func min1(x, y int) int {
	if x < y {
		return x
	}
	return y
}

func max1(x, y int) int {
	if x > y {
		return x
	}
	return y
}
