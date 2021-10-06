package easy
// leetcode-0001 2021/2/23
func TwoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i, num := range nums {
		another := target - num
		_, ok := m[another]
		if ok {
			return []int{m[another], i}
		}
		m[num] = i
	}
	return nil
}
