package dp

import (
	"math"
	"sort"
)

// leetcode-0354 2021/4/26

func maxEnvelopes(envelopes [][]int) (res int) {
	//对 宽度 按照升序排列
	//宽度相同时  对长度按降序排列
	//mySort(envelopes,0,len(envelopes)-1)
	sort.Slice(envelopes, func(i, j int) bool {
		return envelopes[i][0] < envelopes[j][0] || envelopes[i][0] == envelopes[j][0] && envelopes[i][1] > envelopes[j][1]
	})

	//接下来对长度求最长递增子序列的序列元素个数
	n := len(envelopes)
	dp := make([]int, n)
	for i := 0; i < n; i++ {
		dp[i] = 1
		for j := 0; j < i; j++ {
			if envelopes[i][1] > envelopes[j][1] {
				dp[i] = int(math.Max(float64(dp[i]), float64(dp[j])+1))
			}
		}
	}
	for _, i := range dp {
		res = int(math.Max(float64(res), float64(i)))
	}
	return res
}

//快排实现
//func mySort(arr [][]int,l int,r int)  {
//	if l >= r {
//		return
//	}
//	pivot := arr[l]
//	left,right := l, r
//	for left < right {
//		for left<right && (arr[right][0] > pivot[0] || (arr[right][0] == pivot[0] && arr[right][1] <= pivot[1])) {
//			right--
//		}
//		for left<right && (arr[left][0] < pivot[0] || (arr[left][0] == pivot[0] && arr[left][1] >= pivot[1])) {
//			left++
//		}
//		if left < right {
//			temp := arr[left]
//			arr[left] = arr[right]
//			arr[right] = temp
//		}
//	}
//	arr[l] = arr[left]
//	arr[left] = pivot
//	mySort(arr,l,left-1)
//	mySort(arr,right+1,r)
//}
