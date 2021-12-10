package MonotonicStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : LA4AM12
 * @create : 2021-12-10 11:21:50
 * @description : Next Greater Element II
 */
public class Solution503 {
	public int[] nextGreaterElements(int[] nums) {
		Deque<Integer> stack = new LinkedList<>();
		int n = nums.length;
		int[] ans = new int[n];

		for (int i = 2 * n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
				stack.pop();
			}
			ans[i % n] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(nums[i % n]);
		}

		return ans;
	}
}
