package medium

// leetcode-0016 2021/2/25
import (
	"math"
	"sort"
)

func ThreeSumClosest(nums []int, target int) int {
	sort.Ints(nums)
	n := len(nums)
	dist := math.MaxInt32
	var ans int

	for a := 0; a < n-2; a++ {
		if a > 0 && nums[a] == nums[a-1] {
			continue
		}

		for b, c := a+1, n-1; b < c; {
			sum := nums[a] + nums[b] + nums[c]

			if sum == target {
				return target
			} else if sum < target {
				for b < c && nums[b] == nums[b+1] {
					b++
				}
				b++
			} else {
				for b < c && nums[c] == nums[c-1] {
					c--
				}
				c--
			}

			//update
			if int(math.Abs(float64(sum-target))) < dist{
				dist = int(math.Abs(float64(sum-target)))
				ans = sum
			}
		}
	}
	return ans
}
