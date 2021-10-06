package medium

// leetcode-0567 2021/4/8

func checkInclusion(s1 string, s2 string) bool {
	need, window := make(map[byte]int), make(map[byte]int)

	for _, c := range s1 {
		need[byte(c)]++
	}
	valid := 0
	left, right := 0, 0
	for right < len(s2) {
		c := s2[right]
		right++

		if _, in := need[c]; in {
			// 如果是需要的，就加入window
			window[c]++

			//更新状态
			if window[c] == need[c] {
				valid++
			}
		}
		if right-left == len(s1) {
			if valid == len(need) {
				return true
			}
			c = s2[left]
			left++
			if _, in := need[c]; in {
				//更新状态
				if window[c] == need[c] {
					valid--
				}
				window[c]--
			}
		}
	}
	return false
}
