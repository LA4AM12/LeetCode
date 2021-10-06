package Offer;

import java.util.Deque;
import java.util.LinkedList;

public class Solution59 {
    private Deque<Integer> deque;


    public int[] maxSlidingWindow(int[] nums, int k) {
        deque = new LinkedList<>();

        if (nums.length == 0) return new int[0];

        for (int i = 0; i < k; i++) {
            int value = nums[i];
            while (!deque.isEmpty() && deque.peekLast() < value)
                deque.removeLast();
            deque.offer(value);
        }

        int[] ans = new int[nums.length-k+1];

        for (int i = k; i < nums.length; i++) {
            ans[i-k] = deque.peek();
            if (nums[i-k] == deque.peek())
                deque.poll();
            int value = nums[i];
            while (!deque.isEmpty() && deque.peekLast() < value)
                deque.removeLast();
            deque.offer(value);
        }
        ans[nums.length-k] = deque.peek();

        return ans;
    }
}
