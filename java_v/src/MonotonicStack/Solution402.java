package MonotonicStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : LA4AM12
 * @create : 2021-12-04 11:03:27
 * @description : Remove K Digits
 */
public class Solution402 {
	public String removeKdigits(String num, int k) {
		Deque<Integer> stack = new LinkedList<>();
		int len = num.length() - k;
		for (int i = 0; i < num.length(); i++) {
			int n = num.charAt(i) - '0';
			while (!stack.isEmpty() && k > 0 && stack.peekLast() > n){
				stack.pollLast();
				k--;
			}
			stack.offerLast(n);
		}

		StringBuilder res = new StringBuilder();
		boolean leadingZero = true;
		for (int i = 0; i < len; i++) {
			int n = stack.pollFirst();
			if (leadingZero && n == 0)
				continue;
			leadingZero = false;
			res.append(n);
		}
		return res.length() == 0 ? "0" : res.toString();
	}
}
