package medium

// leetcode-0454 2021/12/16

func fourSumCount(a, b, c, d []int) (ans int) {
	//存储a,b元素和出现的次数
	count := make(map[int]int)
	for _, ai := range a {
		for _, bi := range b {
			count[ai+bi]++
		}
	}

	// ai + bi + ci + di = 0  =>  ai + bi = -ci-di
	// 在map中查找（-ci-di）出现的次数
	for _, ci := range c {
		for _, di := range d {
			ans += count[-ci-di]
		}
	}

	return
}
