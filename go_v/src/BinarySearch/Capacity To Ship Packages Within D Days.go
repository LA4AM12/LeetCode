package BinarySearch

// leetcode-1011 2021/4/4

func shipWithinDays(weights []int, D int) int {
	//二分法，先确定上下界
	min, max := 0, 0

	for _, n := range weights {
		max += n
		if min < n {
			min = n
		}
	}

	for min < max {
		least := min + (max-min)/2
		days := 1
		//计算需要几天
		for _, n := range weights {
			least -= n
			if least < 0 {
				days++
				least = min + (max-min)/2 - n
			}
		}
		if days <= D {
			max = min + (max-min)/2
		} else {
			min = min + (max-min)/2 + 1
		}
	}
	return min
}
