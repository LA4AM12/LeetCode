package medium

// leetcode-0005 2021/11/25

func longestPalindrome(s string) string {
	var expandAroundCenter = func(left int, right int) (int, int) {
		for left >= 0 && right < len(s) && s[left] == s[right] {
			left, right = left-1, right+1
		}
		return left + 1, right
	}

	start, end := 0, 1

	for i := 0; i < len(s); i++ {
		s1, e1 := expandAroundCenter(i, i)
		// the center of a palindrome can be in between two letters.
		s2, e2 := expandAroundCenter(i, i+1)

		if e1-s1 > end-start {
			start, end = s1, e1
		}

		if e2-s2 > end-start {
			start, end = s2, e2
		}
	}

	return s[start:end]
}
