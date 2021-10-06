package medium

// leetcode-0739 2021/3/28

//单调栈
//倒着遍历  遇到小于等于的元素 直接弹出
func dailyTemperatures(temperatures []int) []int {
	stack := make([]int,0)
	ans := make([]int,len(temperatures))
	for i := len(temperatures) - 1; i >= 0; i-- {
		//栈非空  且栈顶元素小于或者等于当前元素  直接出栈
		for len(stack)!=0 && temperatures[stack[len(stack)-1]] <= temperatures[i] {
			stack = stack[:len(stack)-1]    //pop
		}
		//栈空  说明当前元素后面没有比它大的元素
		if len(stack) == 0 {
			ans[i] = 0
		}else {
			ans[i] = stack[len(stack)-1] - i
		}

		stack = append(stack,i)
	}
	return ans
}
