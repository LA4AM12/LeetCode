package math;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : LA4AM12
 * @create : 2021-11-09 19:55:26
 * @description :
 */
public class Solution32 {
	public int longestValidParentheses(String s) {
		// The bottom element of the stack is the subscript of the last ')' that is not matched
		Deque<Integer> stack = new LinkedList<>();
		int ans = 0;
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.isEmpty()) {
					// Indicates that the current ')' has not been matched
					stack.push(i);
				} else {
					ans = Math.max(ans,i - stack.peek());
				}
			}
		}
		return ans;
	}
}
