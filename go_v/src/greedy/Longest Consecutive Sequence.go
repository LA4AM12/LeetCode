package greedy

// leetcode-0128 2022/04/17

func longestConsecutive(nums []int) (ans int) {
	set := make(map[int]bool)

	// O(n)
	for _, n := range nums {
		set[n] = true
	}

	// O(2n)
	for n := range set {
		// Start at the beginning of the sequence
		if !set[n-1] {
			tmp := 1
			for set[n+1] {
				n++
				tmp++
			}
			if tmp > ans {
				ans = tmp
			}
		}
	}
	return ans
}
