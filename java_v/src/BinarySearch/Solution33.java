package BinarySearch;

/**
 * @author : LA4AM12
 * @create : 2021-10-28 10:20:44
 * @description : Search in Rotated Sorted Array
 */
public class Solution33 {
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == nums[mid])
				return mid;

			if (nums[mid] < nums[0]) {
				if (nums[mid] < target && target <= nums[nums.length - 1])
					left = mid + 1;
				else
					right = mid - 1;
			} else {
				if (nums[0] <= target && target < nums[mid])
					right = mid - 1;
				else
					left = mid + 1;
			}
		}
		return -1;
	}
}
