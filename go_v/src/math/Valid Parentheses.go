package math

// leetcode-0020 2021/12/22

func isValid(s string) bool {
	stack := make([]byte, 0)
	dict := map[byte]byte{')': '(', '}': '{', ']': '['}

	for i := 0; i < len(s); i++ {
		if s[i] == '(' || s[i] == '{' || s[i] == '[' {
			stack = append(stack, s[i])
		} else if len(stack) > 0 && stack[len(stack)-1] == dict[s[i]] {
			stack = stack[:len(stack)-1]
		} else {
			return false
		}

	}

	return len(stack) == 0
}
