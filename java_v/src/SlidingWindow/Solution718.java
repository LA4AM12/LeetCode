package SlidingWindow;

/**
 * @author : LA4AM12
 * @create : 2022-04-11 08:18:11
 * @description : Maximum Length of Repeated Subarray
 */

/**               FROM
 *          i
 *         [* * * * * * *]
 *   [* * * *]
 *   		       TO
 *   		                     i
 * 		   [* * * * * * *]
 *                        [* * * *]
 */
public class Solution718 {
	public int findLength(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length;
		int len = len1 + len2;
		int ans = 0;

		for (int i = 0; i < len; i++) {
			int start1 = i > len2 - 1 ? i - len2 + 1 : 0;
			int start2 = i < len2 - 1 ? len2 - 1 - i : 0;
			int range = Math.min(len1 - start1, len2 - start2);

			ans = Math.max(ans, findFromStart(nums1, start1, nums2, start2, range));
		}
		return ans;
	}

	private int findFromStart(int[] nums1, int start1, int[] nums2, int start2, int range) {
		int res = 0;
		int k = 0;

		for (int i = 0; i < range; i++) {
			if (nums1[start1 + i] == nums2[start2 + i])
				k++;
			else k = 0;
			res = Math.max(res, k);
		}
		return res;
	}
}
