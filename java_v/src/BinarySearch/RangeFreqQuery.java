package BinarySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author : LA4AM12
 * @create : 2021-11-21 12:46:20
 * @description : 2080. Range Frequency Queries
 */
public class RangeFreqQuery {
	private Map<Integer, TreeMap<Integer, Integer>> map;

	public RangeFreqQuery(int[] arr) {
		this.map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.putIfAbsent(arr[i], new TreeMap<>());
			//Record the number of elements that showed before index i
			map.get(arr[i]).put(i, map.get(arr[i]).size());
		}
	}

	public int query(int left, int right, int value) {
		if (!map.containsKey(value)) return 0;
		TreeMap<Integer, Integer> treeMap = map.get(value);
		Map.Entry<Integer, Integer> e1 = treeMap.ceilingEntry(left);
		Map.Entry<Integer, Integer> e2 = treeMap.floorEntry(right);

		if (e1 == null || e2 == null) return 0;

		return e2.getValue() - e1.getValue() + 1;
	}
}
