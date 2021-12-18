package easy

func strStr(haystack string, needle string) int {
	if len(needle) == 0 {
		return 0
	}
	next := getNext(needle)
	j := 0

	for i := 0; i < len(haystack); i++ {
		for j > 0 && haystack[i] != needle[j] {
			j = next[j-1]
		}
		if haystack[i] == needle[j] {
			j++
			if j == len(needle) {
				return i - j + 1
			}
		}
	}

	return -1
}

// P自己与自己做匹配
func getNext(p string) []int {
	next := make([]int, len(p))
	j := 0 // 指向前缀末尾
	next[0] = j

	// next[x] 定义为： P[0]~P[x] 这一段字符串最长相等前后缀
	for i := 1; i < len(p); i++ { // i 指向后缀末尾
		for j > 0 && p[i] != p[j] {
			j = next[j-1]
		}
		if p[i] == p[j] {
			j++
		}
		next[i] = j
	}
	return next
}
