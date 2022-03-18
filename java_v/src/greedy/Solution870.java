package greedy;

import java.util.Arrays;

/**
 * @author : LA4AM12
 * @create : 2022-03-17 16:11:13
 * @description : Advantage Shuffle
 */
public class Solution870 {
	public int[] advantageCount(int[] nums1, int[] nums2) {
		int len = nums1.length;
		int[] ans = new int[len];
		boolean[] used = new boolean[len];
		Arrays.sort(nums1);

		for (int i = 0; i < len; i++) {
			int idx = Math.abs(Arrays.binarySearch(nums1, nums2[i]) + 1);
			// Find the first element larger than it, if any
			while (idx < len && nums1[idx] == nums2[i]) {
				idx++;
			}
			while (idx > 0 && nums1[idx - 1] > nums2[i]) {
				idx--;
			}
			idx %= len;
			while (used[idx]) {
				idx = (idx + 1) % len;
			}
			ans[i] = nums1[idx];
			used[idx] = true;
		}
		return ans;
	}
}
