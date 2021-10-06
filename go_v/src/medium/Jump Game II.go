package medium

// leetcode-0045 2021/05/12

func jump(nums []int) int {
	n := len(nums)


	pos := 0    //当前跳到的位置

	//第i次跳  最多就跳n-1次
	for i := 1; i < n; i++ {

		if nums[pos] + pos >= n-1 {
			return i
		}

		max := 0
		next := 0

		for j := 1; j <= nums[pos]; j++ {

			//选出满足nums[pos+j]+pos+j最大的j
			if max < nums[pos+j]+pos+j {
				max = nums[pos+j]+pos+j
				next = j
			}
		}
		pos = pos + next
	}
	return 0
}