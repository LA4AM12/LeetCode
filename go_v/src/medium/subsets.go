package medium

// leetcode-0078 2021/3/5

//方法一：bit mask
func subsets(nums []int) [][]int {
	n, res := len(nums), make([][]int, 0)
	for i := 0; i < (1 << n); i++ {
		set := make([]int, 0)
		for index, num := range nums {
			if i>>index&1 > 0 {
				set = append(set, num)
			}
		}
		res = append(res, set)
	}
	return res
}

//方法二：
func subsets1(nums []int) [][]int {
	res := make([][]int, 1)
	for _, num := range nums {
		for _, set := range res {
			newSet := make([]int, len(set), len(set)+1)
			copy(newSet, set)
			newSet = append(newSet, num)
			res = append(res, newSet)
		}
	}
	return res
}
