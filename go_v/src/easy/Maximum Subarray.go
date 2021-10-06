package easy

// leetcode-0053 2021/4/22


func maxSubArray(nums []int) int {
	var pos,sum int
	max := nums[0]
	l := len(nums)
	for pos < l {
		sum += nums[pos]
		if max < sum {
			max = sum
		}
		if sum < 0 {
			sum = 0
		}
		pos++
	}
	return max
}