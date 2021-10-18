package dp;

import java.util.HashMap;
import java.util.Map;

public class Solution887 {
	Map<Integer, Integer> memo = new HashMap<>();

	public int superEggDrop(int k, int n) {
		if (k == 1) return n;
		if (n == 0) return 0;

		if (!memo.containsKey(100 * n + k)) {
			int res = Integer.MAX_VALUE;

			// chose a floor
			// for (int i = 1; i <= n + 1; i++) {
			// 	res = Math.min(res, Math.max(superEggDrop(k - 1, i - 1), superEggDrop(k, n - i)) + 1);
			// }

			// binary search
			int lo = 1, hi = n;
			while (lo <= hi) {
				int mid = (lo + hi) >> 1;
				int broken = superEggDrop(k - 1, mid - 1);
				int notBroken = superEggDrop(k, n - mid);
				if (broken > notBroken) {
					hi = mid - 1;
					res = Math.min(res, broken + 1);
				} else {
					lo = mid + 1;
					res = Math.min(res, notBroken + 1);
				}
			}

			memo.put(100 * n + k, res);
		}

		return memo.get(100 * n + k);
	}
}
