package SlidingWindow

// leetcode-0438 2021/4/9

func findAnagrams(s string, p string) (ans []int) {
	need, window := make(map[byte]int), make(map[byte]int)
	left, right := 0, 0
	valid := 0
	for _, c := range p {
		need[byte(c)]++
	}

	for right < len(s) {
		c := s[right]
		right++
		if n, in := need[c]; in {
			window[c]++
			if window[c] == n {
				valid++
			}
		}
		if right-left == len(p) {
			if valid == len(need) {
				ans = append(ans, left)
			}
			c = s[left]
			left++
			if n, in := need[c]; in {
				if window[c] == n {
					valid--
				}
				window[c]--
			}
		}
	}
	return ans
}
