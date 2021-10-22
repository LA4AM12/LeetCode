package niuke;

import java.util.Deque;
import java.util.LinkedList;


/**
 * @author : LA4AM12
 * @create : 2021-10-22 16:57:38
 * @description : big integer sum
 */
public class NC1 {
	public String solve(String s, String t) {
		int d1 = s.length() - 1, d2 = t.length() - 1;
		int carry = 0;
		Deque<Integer> stack = new LinkedList<>();

		while (d1 >= 0 || d2 >= 0 || carry > 0) {
			int a = d1 < 0 ? 0 : s.charAt(d1--) - '0';
			int b = d2 < 0 ? 0 : t.charAt(d2--) - '0';

			int sum = a + b + carry;
			carry = sum >= 10 ? 1 : 0;

			stack.push(sum % 10);
		}

		StringBuilder st = new StringBuilder();
		while (!stack.isEmpty()) {
			st.append(stack.pop());
		}

		return st.toString();
	}
}
