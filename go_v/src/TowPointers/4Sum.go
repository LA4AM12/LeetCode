package TowPointers

// leetcode-0018 2021/2/26
import (
	"sort"
)

func fourSum(nums []int, target int) [][]int {
	sort.Ints(nums)
	length, sum, res := len(nums), 0, make([][]int, 0)
	for n1 := 0; n1 < length-3; n1++ {
		if n1 > 0 && nums[n1] == nums[n1-1] {
			continue
		}
		for n2 := n1 + 1; n2 < length-2; n2++ {
			if n2 > n1+1 && nums[n2] == nums[n2-1] {
				continue
			}
			n3, n4 := n2+1, length-1
			for n3 < n4 {
				if n3 > n2+1 && nums[n3] == nums[n3-1] {
					n3++
					continue
				}
				if n4 < length-1 && nums[n4] == nums[n4+1] {
					n4--
					continue
				}
				sum = nums[n1] + nums[n2] + nums[n3] + nums[n4]
				if sum == target {
					res = append(res, []int{nums[n1], nums[n2], nums[n3], nums[n4]})
					n3++
					n4--
				} else if sum < target {
					n3++
				} else {
					n4--
				}
			}
		}
	}
	return res
}
