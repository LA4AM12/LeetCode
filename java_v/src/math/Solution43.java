package math;

/**
 * @author : LA4AM12
 * @create : 2021-10-22 17:56:57
 * @description : Multiply Strings
 */
public class Solution43 {
	public String multiply(String num1, String num2) {
		int d1 = num1.length();
		int d2 = num2.length();

		int[] res = new int[d1 + d2];
		for (int i = d1 - 1; i >= 0; i--) {
			for (int j = d2 - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j, p2 = i + j + 1;
				int sum = mul + res[p2];
				res[p2] = sum % 10;
				res[p1] += sum / 10;
			}
		}

		int i = 0;
		while (i < d1 + d2 - 1 && res[i] == 0)
			i++;

		StringBuilder st = new StringBuilder(d1 + d2 - i);
		while (i < d1 + d2)
			st.append(res[i++]);

		return st.toString();
	}
}
