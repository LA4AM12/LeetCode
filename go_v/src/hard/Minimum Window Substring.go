package hard

// leetcode-0076 2021/4/7

func minWindow(s string, t string) string {
	need, window := make(map[byte]int), make(map[byte]int)
	//标记结果的左右
	lMark, rMark := -1, -1
	//得到所需要的字符及个数
	for _, c := range t {
		need[byte(c)]++
	}
	//滑动窗口的左右 [  )
	left, right := 0, 0
	//window 中满足条件的个数
	valid := 0

	for right < len(s) {
		//即将移入窗口的字符
		c := s[right]
		right++
		//更新窗口内的数据
		if _, ok := need[c]; ok {
			window[c]++

			//更新满足条件的个数
			if window[c] == need[c] {
				valid++
			}
		}

		//满足所有字符后，左侧开始收缩
		for valid == len(need) {
			c = s[left]
			left++

			//更新窗口内的数据
			if _, ok := need[c]; ok {
				window[c]--
				//更新满足条件的个数
				if window[c] < need[c] {
					valid--

					//如果长度小就记录一下
					if rMark == -1 || right-left+1 < rMark-lMark {
						rMark = right
						lMark = left - 1
					}
				}
			}
		}
	}
	if rMark == -1 {
		return ""
	}
	return s[lMark:rMark]
}
