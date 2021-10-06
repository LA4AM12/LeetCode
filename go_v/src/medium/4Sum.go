package medium
// leetcode-0018 2021/2/26
import (
	"sort"
)

func FourSum(nums []int, target int) [][]int {
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

//解法2， 利用map
func fourSum(nums []int, target int) [][]int {
	counter, res := make(map[int]int), make([][]int, 0)
	for _, v := range nums {
		counter[v]++
	}
	uniqNums := make([]int, 0)
	for k := range counter {
		uniqNums = append(uniqNums, k)
	}
	sort.Ints(uniqNums)
	length := len(uniqNums)
	for n1 := 0; n1 < length; n1++ {
		if uniqNums[n1]*4 == target && counter[uniqNums[n1]] >= 4 {
			res = append(res, []int{uniqNums[n1], uniqNums[n1], uniqNums[n1], uniqNums[n1]})
		}
		for n2 := n1 + 1; n2 < length; n2++ {
			if uniqNums[n1]*3+uniqNums[n2] == target && counter[uniqNums[n1]] >= 3 {
				res = append(res, []int{uniqNums[n1], uniqNums[n1], uniqNums[n1], uniqNums[n2]})
			}
			if uniqNums[n1]+uniqNums[n2]*3 == target && counter[uniqNums[n2]] >= 3 {
				res = append(res, []int{uniqNums[n1], uniqNums[n2], uniqNums[n2], uniqNums[n2]})
			}
			if uniqNums[n1]*2+uniqNums[n2]*2 == target &&counter[uniqNums[n1]] >= 2&& counter[uniqNums[n2]] >= 2 {
				res = append(res, []int{uniqNums[n1], uniqNums[n1], uniqNums[n2], uniqNums[n2]})
			}
			for n3:=n2+1;n3<length;n3++ {
				if uniqNums[n1]*2+uniqNums[n2]+uniqNums[n3] == target && counter[uniqNums[n1]] >= 2 {
					res = append(res, []int{uniqNums[n1], uniqNums[n1], uniqNums[n2], uniqNums[n3]})
				}
				if uniqNums[n1]+uniqNums[n2]*2+uniqNums[n3] == target && counter[uniqNums[n2]] >= 2 {
					res = append(res, []int{uniqNums[n1], uniqNums[n2], uniqNums[n2], uniqNums[n3]})
				}
				if uniqNums[n1]+uniqNums[n2]+uniqNums[n3]*2 == target && counter[uniqNums[n3]] >= 2 {
					res = append(res, []int{uniqNums[n1], uniqNums[n2], uniqNums[n3], uniqNums[n3]})
				}
				d := target - (uniqNums[n1]+uniqNums[n2]+uniqNums[n3])
				if  d>uniqNums[n3]&&counter[d]>0  {
					res = append(res, []int{uniqNums[n1], uniqNums[n2], uniqNums[n3], d})
				}
			}
		}
	}
	return res
}
