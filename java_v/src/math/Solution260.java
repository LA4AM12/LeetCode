package math;

/**
 * @author : LA4AM12
 * @create : 2022-04-15 10:04:27
 * @description : Single Number III
 */
public class Solution260 {
	public int[] singleNumber(int[] nums) {
		int x = 0;
		for (int n : nums) {
			x ^= n;
		}
		// x = a ^ b
		// (-x) = ~x + 1
		int mask = x & (-x);
		int a = 0, b = 0;

		// partition
		for (int n : nums) {
			if ((n & mask) == 0)
				a ^= n;
			else
				b ^= n;
		}

		return new int[]{a, b};
	}
}
