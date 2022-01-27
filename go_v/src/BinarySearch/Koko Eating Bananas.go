package BinarySearch

import "math"

// leetcode-0875 2021/4/1

func minEatingSpeed(piles []int, h int) int {
	//时间范围 min-max
	max := math.MinInt64
	for _, n := range piles {
		if n > max {
			max = n
		}
	}
	min := max/h + 1

	for min < max {
		speed := min + (max-min)/2
		time := 0
		for _, n := range piles {
			time += n / speed
			if n%speed != 0 {
				time++
			}
		}
		if time <= h {
			max = speed
		} else {
			min = speed + 1
		}
	}

	return min
}
