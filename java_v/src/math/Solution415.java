package math;

/**
 * @author : LA4AM12
 * @create : 2021-11-23 10:13:11
 * @description : Add Strings
 */
public class Solution415 {
	public String addStrings(String num1, String num2) {
		StringBuilder res = new StringBuilder();
		int n1 = num1.length(), n2 = num2.length();

		int sum, carry = 0;
		while (n1 > 0 || n2 > 0) {
			int a = --n1 < 0 ? 0 : num1.charAt(n1) - '0';
			int b = --n2 < 0 ? 0 : num2.charAt(n2) - '0';

			sum = a + b + carry;
			res.append(sum % 10);
			carry = sum < 10 ? 0 : 1;
		}
		if (carry != 0) res.append('1');
		return res.reverse().toString();
	}
}
