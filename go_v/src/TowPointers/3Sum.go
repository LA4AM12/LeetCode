package TowPointers

// leetcode-0015 2021/2/24
import "sort"

func threeSum(nums []int) [][]int {
	sort.Ints(nums) //先排序 方便去除重复
	n := len(nums)
	ans := make([][]int, 0)

	//枚举 a ,其中 a<=b<=c
	for a := 0; a < n-2; a++ {
		//去除重复情况
		if a > 0 && nums[a] == nums[a-1] {
			continue
		}

		//寻找 b c 满足 nums[b]+nums[c] = target
		target := -1 * nums[a]

		//枚举 b c
		for b, c := a+1, n-1; b < n-1; b++ {
			//去除重复情况
			if b > a+1 && nums[b] == nums[b-1] {
				continue
			}
			for b < c && nums[b]+nums[c] > target {
				c--
			}
			if b == c {
				break
			}
			if nums[b]+nums[c] == target {
				ans = append(ans, []int{nums[a], nums[b], nums[c]})
			}
		}
	}
	return ans
}
