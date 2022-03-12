package PrefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : LA4AM12
 * @create : 2022-03-12 14:57:54
 * @description : Subarray Sums Divisible by K
 */
public class Solution974 {
	public int subarraysDivByK(int[] nums, int k) {
		Map<Integer, Integer> dict = new HashMap<>();
		dict.put(0, 1);

		int sum = 0, ans = 0;
		for (int n : nums) {
			sum += n;
			int m = (sum % k + k) % k;
			int times = dict.getOrDefault(m, 0);
			ans += times;
			dict.put(m, times + 1);
		}

		return ans;
	}
}
