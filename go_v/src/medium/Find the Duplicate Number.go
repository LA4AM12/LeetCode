package medium
// leetcode-0287 2021/3/8

func findDuplicate1(nums []int) (ans int) {
	a:=make([]int,len(nums))
	for _,num:=range nums{
		a[num]++
		if a[num] == 2 {
			ans = num
			break
		}
	}
	return ans
}
