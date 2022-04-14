package dfs

import "strings"

// leetcode-0394 2022/4/14

func decodeString(s string) string {
	var i int
	return dfs(s, &i)
}

func dfs(s string, i *int) string {
	var multi int
	var res string
	for *i < len(s) {
		c := s[*i]
		if '0' <= c && c <= '9' {
			multi = multi*10 + int(c-'0')
		} else if c == '[' {
			*i++
			tmp := dfs(s, i)
			res += strings.Repeat(tmp, multi)
			multi = 0
		} else if c == ']' {
			return res
		} else {
			res += string(c)
		}
		*i++
	}
	return res
}
