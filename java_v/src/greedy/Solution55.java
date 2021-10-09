package greedy;

/**
 * @author : LA4AM12
 * @create : 2021-10-09 10:35:47
 * @description : 55_Jump Game
 */

public class Solution55 {
	public boolean canJump(int[] nums) {
		int furthest = 0;

		int i = 0;

		while (i <= furthest){
			if (nums[i] + i > furthest)
				furthest = nums[i] + i;
			if (furthest >= nums.length - 1)
				return true;
			i++;
		}

		return false;
	}
}
