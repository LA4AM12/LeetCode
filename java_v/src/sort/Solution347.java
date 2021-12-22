package sort;

import java.util.*;

/**
 * @author : LA4AM12
 * @create : 2021-12-22 13:54:26
 * @description : Top K Frequent Elements
 */
public class Solution347 {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> occurs = new HashMap<>();
		for (int num : nums) {
			occurs.put(num, occurs.getOrDefault(num, 0) + 1);
		}

		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(occurs.entrySet());
		// Map.Entry<Integer, Integer>[] arr = (Map.Entry<Integer, Integer>[]) occurs.entrySet().toArray();
		int[] ans = new int[k];
		quickSelect(list, 0, list.size() - 1, k);
		for (int i = 0; i < k; i++) {
			ans[i] = list.get(i).getKey();
		}
		return ans;
	}

	private void quickSelect(List<Map.Entry<Integer, Integer>> list, int left, int right, int k) {
		if (left < right) {
			int l = left, r = right;
			int picked = new Random().nextInt(right - left + 1) + left;
			Collections.swap(list, l, picked);
			Map.Entry<Integer, Integer> pivot = list.get(l);

			while (l < r) {
				while (l < r && list.get(r).getValue() < pivot.getValue()) r--;
				list.set(l, list.get(r));

				while (l < r && list.get(l).getValue() >= pivot.getValue()) l++;
				list.set(r, list.get(l));
			}
			list.set(l, pivot);

			if (l > k)
				quickSelect(list, left, r - 1, k);
			else if (l < k)
				quickSelect(list, l + 1, right, k);
		}
	}
}
