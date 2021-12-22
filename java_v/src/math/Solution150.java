package math;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : LA4AM12
 * @create : 2021-12-22 11:29:20
 * @description : Evaluate Reverse Polish Notation
 */
public class Solution150 {
	public int evalRPN(String[] tokens) {
		Deque<Integer> stack = new LinkedList<>();
		for (String opt : tokens) {
			switch (opt) {
				case "+":
					stack.push(stack.pop() + stack.pop());
					break;
				case "-":
					stack.push(-stack.pop() + stack.pop());
					break;
				case "*":
					stack.push(stack.pop() * stack.pop());
					break;
				case "/":
					int n1 = stack.pop();
					int n2 = stack.pop();
					stack.push(n2 / n1);
					break;
				default:
					stack.push(Integer.valueOf(opt));
			}
		}
		return stack.pop();
	}
}
