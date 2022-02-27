package dp;

/**
 * @author : LA4AM12
 * @create : 2022-02-27 15:05:28
 * @description : Maximum Product Subarray
 */
public class Solution152 {
	public int maxProduct(int[] nums) {
		// iMax/iMin denotes maximum/minimum product of subarray end with nums[i]
		int ans, iMax, iMin;
		// init
		ans = iMax = iMin = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < 0) {
				int tmp = iMax;
				iMax = iMin;
				iMin = tmp;
			}
			iMax = Math.max(iMax * nums[i], nums[i]);
			iMin = Math.min(iMin * nums[i], nums[i]);

			ans = Math.max(ans, iMax);
		}

		return ans;
	}
}
