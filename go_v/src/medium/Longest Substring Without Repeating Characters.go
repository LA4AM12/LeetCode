package medium

// leetcode-0003 2021/4/10

func lengthOfLongestSubstring(s string) int {
	var max int
	window := make(map[byte]int)
	left, right := 0, 0
	for right < len(s) {
		c := s[right]
		right++
		window[c]++
		if window[c] == 2 {
			for left < right {
				cl := s[left]
				left++
				if c == cl {
					window[c] = 1
					break
				} else {
					delete(window, cl)
				}
			}
		}
		if max < len(window) {
			max = len(window)
		}
	}
	return max
}
