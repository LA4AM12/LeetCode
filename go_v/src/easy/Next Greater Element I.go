package easy

// leetcode-0496 2021/3/10

//单调栈
func nextGreaterElement(nums1 []int, nums2 []int) (ans []int) {
	stack := make([]int,0)
	dic := make(map[int]int)
	for _,n2:= range nums2{
		for len(stack)>0 && stack[len(stack)-1] < n2 {
			dic[stack[len(stack)-1]] = n2
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, n2)
	}
	for _,n1:=range nums1{
		next,ok := dic[n1]
		if ok {
			ans = append(ans, next)
		}else {
			ans = append(ans, -1)
		}
	}
	return ans
}
