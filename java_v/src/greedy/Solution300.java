package greedy;

/**
 * @author : LA4AM12
 * @create : 2021-11-06 10:23:53
 * @description : Longest Increasing Subsequence
 */
public class Solution300 {
	public int lengthOfLIS(int[] nums) {
		int[] p = new int[nums.length];
		p[0] = nums[0];
		int len = 1;

		// Use the smallest possible number to form LIS
		// The smaller number in the back replaces the larger number in the front
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > p[len - 1]) {
				p[len++] = nums[i];
			} else {
				// binary search
				int l = 0, r = len - 1;
				while (l < r) {
					int m = (l + r) >>> 1;
					if (p[m] < nums[i]) {
						l = m + 1;
					} else {
						r = m;
					}
				}
				p[l] = nums[i];
			}
		}
		return len;
	}
}
