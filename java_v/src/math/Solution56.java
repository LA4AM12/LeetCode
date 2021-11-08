package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2021-11-08 14:34:55
 * @description : Merge Intervals
 */
public class Solution56 {
	public int[][] merge(int[][] intervals) {

		//sort
		Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));


		List<int[]> merged = new ArrayList<>();
		for (int[] interval : intervals) {
			int L = interval[0], R = interval[1];
			if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
				merged.add(new int[]{L, R});
			} else {
				merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}
}
