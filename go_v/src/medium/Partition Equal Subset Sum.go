package medium

// leetcode-0416 2021/4/21

//转换为背包问题

func canPartition(nums []int) bool {
	var sum int
	for _, num := range nums {
		sum += num
	}
	if sum%2 != 0 {
		return false
	} else {
		sum = sum / 2
	}

	n := len(nums)
	dp := make([]bool, sum+1)

	//求 dp[n][sum]   对前n个数能否凑出sum

	//对于 dp[i][j] = dp[i-1][j-num[i-1]] || dp[i-1][j]

	//状态压缩   求dp[sum]

	//base case
	dp[0] = true
	for i := 0; i < n; i++ {
		for j := sum; j >= 0; j-- {
			if j-nums[i] >= 0 {
				dp[j] = dp[j] || dp[j-nums[i]] //由于这里对应的是i-1的情况 所以必须倒着遍历
			}
		}
	}

	return dp[sum]
}
