package MonotonicStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : LA4AM12
 * @create : 2021-12-22 13:00:29
 * @description : Sliding Window Maximum
 */
public class Solution239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> deque = new LinkedList<>();
		int[] ans = new int[nums.length - k + 1];

		for (int i = 0; i < nums.length; i++) {
			// remove the element out of range (i-k:i]
			while (!deque.isEmpty() && deque.peekFirst() <= i - k)
				deque.pollFirst();

			// monotonic queue
			while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
				deque.pollLast();

			deque.offer(i);  // offer last

			if (i >= k - 1)
				ans[i - k + 1] = nums[deque.peek()];   // peek first --- the max
		}

		return ans;
	}
}
