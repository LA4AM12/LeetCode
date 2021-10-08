package greedy;

import java.util.Arrays;

/**
 * @author : LA4AM12
 * @create : 2021-10-08 13:34:30
 */
public class Solution1024 {
	public int videoStitching(int[][] clips, int time) {
		// asc for start & desc for end
		Arrays.sort(clips,(o1,o2)->o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

		// find the next farthest end
		int cur_end = 0, next_end = 0;
		int ans = 0;
		int i = 0, n = clips.length;

		while (i < n && clips[i][0] <= cur_end) {
			while (i < n && clips[i][0] <= cur_end){
				next_end = Math.max(next_end,clips[i][1]);
				++i;
			}

			cur_end = next_end;
			++ans;

			if (cur_end >= time)
				return ans;
		}
		return -1;
	}
}
