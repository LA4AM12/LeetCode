package greedy

import (
	"sort"
)

// leetcode-0435 2021/05/08

func eraseOverlapIntervals(intervals [][]int) int {

	//先把interval的end按从小到大排好序
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][1] < intervals[j][1]
	})
	var count int
	end := intervals[0][1]

	for i := 1; i < len(intervals); i++ {
		if intervals[i][0] < end {
			count++
		} else {
			end = intervals[i][0]
		}
	}

	return count
}
