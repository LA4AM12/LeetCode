package PrefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : LA4AM12
 * @create : 2022-02-27 10:58:55
 * @description : Subarray Sum Equals K
 */
public class Solution560 {
	public int subarraySum(int[] nums, int k) {
		int count = 0, preSum = 0;
		// key: preSum value: show times of preSum
		Map<Integer, Integer> map = new HashMap<>();
		// init prefixSum[-1] = 0  --> prefixSum[j] - prefixSum[-1] = prefixSum[j]
		map.put(0, 1);

		// subarray end with n
		for (int n : nums) {
			preSum += n;
			if (map.containsKey(preSum - k))
				count += map.get(preSum - k);
			map.put(preSum, map.getOrDefault(preSum, 0) + 1);
		}

		return count;
	}
}
