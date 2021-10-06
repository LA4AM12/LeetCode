package easy

// leetcode-0088 2021/3/6

//func Merge(nums1 []int, m int, nums2 []int, n int) {
//	temp := make([]int,m)
//	copy(temp,nums1[:m])
//	var pt, i, j int
//	for i, j = 0, 0; i < m && j < n; pt++ {
//		if temp[i] < nums2[j] {
//			nums1[pt] = temp[i]
//			i++
//		} else {
//			nums1[pt] = nums2[j]
//			j++
//		}
//	}
//	if i < m {
//		nums1 = append(nums1[:pt], temp[i:]...)
//	}
//	if j < n {
//		nums1 = append(nums1[:pt], nums2[j:]...)
//	}
//}
func merge(nums1 []int, m int, nums2 []int, n int) {
	for i, j, tail := m-1, n-1, m+n-1; i >= 0 || j >= 0; tail-- {
		if i < 0 || j >= 0 && nums1[i] < nums2[j] {
			nums1[tail] = nums2[j]
			j--
		} else {
			nums1[tail] = nums1[i]
			i--
		}
	}
}
