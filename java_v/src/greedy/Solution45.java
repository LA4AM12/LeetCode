package greedy;

/**
 * @author : LA4AM12
 * @create : 2021-10-09 10:52:00
 * @description : Jump Game II
 */

public class Solution45 {
	public int jump(int[] nums) {
		int jumps = 0;
		int end = 0, furthest = 0;
		int n = nums.length;

		// [i,end] denotes the landing range of the previous jump
		for (int i = 0; i < n - 1; i++) {
			furthest = Math.max(nums[i] + i, furthest);

			if (i == end) {
				end = furthest;
				++jumps;
			}
		}
		return jumps;
	}
}
