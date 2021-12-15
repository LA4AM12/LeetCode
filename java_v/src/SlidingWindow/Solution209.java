package SlidingWindow;

/**
 * @author : LA4AM12
 * @create : 2021-12-15 20:09:11
 * @description : Minimum Size Subarray Sum
 */
public class Solution209 {
	public int minSubArrayLen(int target, int[] nums) {
		int l = -1, r = 0;
		int sum = 0;
		int ans = nums.length + 1;
		while (r < nums.length) {
			sum += nums[r++];
			if (sum >= target){
				while (sum >= target) sum -= nums[++l];
				ans = Math.min(ans, r - l);
			}
		}
		return ans == nums.length + 1 ? 0 : ans;
	}
}
