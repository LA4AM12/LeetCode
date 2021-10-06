package medium

// leetcode-0316 2021/4/11

func removeDuplicateLetters(s string) string {
	stack := make([]byte, 0)
	count := make([]byte, 256)
	for _, c := range s {
		count[c]++
	}

	for _, c := range s {
		//入栈
		if len(stack) > 0 {
			if exists(stack, byte(c)) {
				count[c]--
				continue
			} else {
				for len(stack) > 0 && stack[len(stack)-1] > byte(c) && count[stack[len(stack)-1]] > 0 {
					stack = stack[:len(stack)-1]
				}
			}
		}
		stack = append(stack, byte(c))
		count[c]--
	}
	return string(stack)
}

func exists(l []byte, t byte) bool {
	for _, c := range l {
		if c == t {
			return true
		}
	}
	return false
}
