package math;

/**
 * @author : LA4AM12
 * @create : 2021-11-06 11:06:05
 * @description : First Missing Positive
 */
public class Solution41 {
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;

		// the possible answer must be range [1,n+1]

		// replace Non-positive numbers with a number greater than n
		// cus we don't care about the number greater than n
		for (int i = 0; i < n; i++) {
			if (nums[i] <= 0)
				nums[i] = n + 1;
		}

		// mark
		for (int i = 0; i < n; ++i) {
			int pos = Math.abs(nums[i]) - 1;
			if (pos < n) {
				nums[pos] = -Math.abs(nums[pos]);
			}
		}

		for (int i = 0; i < n; i++) {
			if (nums[i] > 0)
				return i + 1;
		}

		return n + 1;
	}
}
