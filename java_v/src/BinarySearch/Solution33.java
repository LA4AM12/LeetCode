package BinarySearch;

/**
 * @author : LA4AM12
 * @create : 2021-10-28 10:20:44
 * @description : Search in Rotated Sorted Array
 */
public class Solution33 {
	// log(n) bs
	public int search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;

		while (l <= r) {
			int m = (l + r) >>> 1;
			if (target == nums[m])
				return m;
			if (nums[m] < nums[0]) {
				if (nums[m] < target && target <= nums[r])
					l = m + 1;
				else
					r = m - 1;
			} else {
				if (nums[l] <= target && target < nums[m])
					r = r - 1;
				else
					l = m + 1;
			}
		}
		return -1;
	}
}
