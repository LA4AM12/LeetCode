package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : LA4AM12
 * @create : 2021-10-08 10:45:48
 */

// We might try to use the greedy mindset to solve it, but that doesn't work
public class Solution435 {
	public int eraseOverlapIntervals(int[][] intervals) {

		// sort by end
		Arrays.sort(intervals, Comparator.comparingInt(o->o[1]));

		int ans = 0;
		int flag = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < flag){
				++ans;
			} else {
				flag = intervals[i][1];
			}
		}

		return ans;
	}
}
