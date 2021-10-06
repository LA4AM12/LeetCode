package medium

// leetcode-0075 2021/2/27

func sortColors(nums []int) {
	r,w,b := 0,0,0
	for _,num:=range nums{
		if num == 0 {
			nums[b] = 2
			b++
			nums[w] = 1
			w++
			nums[r] = 0
			r++
		}else if num ==1 {
			nums[b] = 2
			b++
			nums[w] = 1
			w++
		}else {
			nums[b] = 2
			b++
		}
	}
}
