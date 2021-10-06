package medium

// leetcode-0216 2021/3/7

//dfs + 回溯
func CombinationSum3(k int, n int) (ans [][]int) {
	temp := make([]int, 0)
	var dfs func(cur, rest int)
	dfs = func(cur, rest int) {
		if len(temp) == k && rest == 0 {
			ans = append(ans, append([]int(nil),temp...))
			return
		}
		//剩余数字用完也不足k个 -> 剪枝   同时防止 cur > 9
		if len(temp) >= k || len(temp)+10-cur < k || rest < 0 {
			return
		}
		//选当前数字
		temp = append(temp, cur)
		dfs(cur+1, rest-cur)
		temp = temp[:len(temp)-1]
		//跳过当前数字
		dfs(cur+1,rest)
	}
	dfs(1, n)
	return ans
}

//方法二 mask求所有子集 筛选出满足条件的子集
