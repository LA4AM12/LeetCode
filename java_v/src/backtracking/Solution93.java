package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2021-11-15 12:25:10
 * @description : Restore IP Addresses
 */
public class Solution93 {
	static final int SEG_COUNT = 4;
	List<String> ans = new ArrayList<>();
	int[] segments = new int[SEG_COUNT];
	int len;

	public List<String> restoreIpAddresses(String s) {
		len = s.length();
		dfs(s, 0, 0);
		return ans;
	}

	public void dfs(String s, int segId, int segStart) {
		//剪枝
		if (len - segStart < SEG_COUNT - segId || len - segStart > 3 * (SEG_COUNT - segId))
			return;

		//结束条件
		if (segId == SEG_COUNT) {
			StringBuilder ip = new StringBuilder();
			for (int i = 0; i < SEG_COUNT; i++) {
				ip.append(segments[i]);
				if (i != SEG_COUNT - 1)
					ip.append('.');
			}
			ans.add(ip.toString());
			return;
		}

		// 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
		if (s.charAt(segStart) == '0') {
			segments[segId] = 0;
			dfs(s, segId + 1, segStart + 1);
		} else {
			int seg = 0;
			for (int i = segStart; i < len; i++) {
				seg = seg * 10 + (s.charAt(i) - '0');
				if (seg <= 255) {
					segments[segId] = seg;
					dfs(s, segId + 1, i + 1);
				} else {
					break;
				}
			}
		}
	}
}
