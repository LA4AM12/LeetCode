package BinarySearch;

/**
 * @author : LA4AM12
 * @create : 2022-04-03 16:17:53
 * @description : Median of Two Sorted Arrays
 */
public class Solution4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length;
		int len = len1 + len2;
		double ans;

		if (len % 2 == 1)
			ans = getKthElement(nums1, nums2, len / 2 + 1);
		else
			ans = (getKthElement(nums1, nums2, len / 2) + getKthElement(nums1, nums2, len / 2 + 1)) / 2.0;

		return ans;
	}

	private int getKthElement(int[] nums1, int[] nums2, int k) {
		int start1 = 0, start2 = 0;

		while (true) {
			if (start1 == nums1.length)
				return nums2[start2 + k - 1];
			if (start2 == nums2.length)
				return nums1[start1 + k - 1];
			if (k == 1)
				return Math.min(nums1[start1], nums2[start2]);

			int idx1 = Math.min(start1 + k / 2, nums1.length) - 1;
			int idx2 = Math.min(start2 + k / 2, nums2.length) - 1;

			if (nums1[idx1] <= nums2[idx2]) {
				k -= (idx1 - start1 + 1);  // exclude
				start1 = idx1 + 1;
			} else {
				k -= (idx2 - start2 + 1);  // exclude
				start2 = idx2 + 1;
			}
		}
	}
}
