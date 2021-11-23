package BinarySearch;

/**
 * @author : LA4AM12
 * @create : 2021-11-23 09:44:46
 * @description : Find Peak Element
 */
public class Solution162 {
	public int findPeakElement(int[] nums) {
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = (l + r) >>> 1;
			// If the middle element lies in an ascending sequence of numbers, or a rising slope
			// it obviously implies that the peak lies towards the right of this element.
			if (nums[mid] < nums[mid + 1])
				l = mid + 1;
			else           //  nums[mid] > nums[mid + 1]
				r = mid;   // Constraints: nums[i] != nums[i + 1] for all valid i.
		}

		return l;
	}
}
