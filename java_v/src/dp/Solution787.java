package dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2021-10-16 08:58:34
 * @description : Cheapest Flights Within K Stops
 */
public class Solution787 {
	private HashMap<Integer, List<int[]>> outdegree;
	private int[][] memo;

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		outdegree = new HashMap<>();
		memo = new int[n][k+1];

		for (int[] f : flights) {
			outdegree.putIfAbsent(f[0], new LinkedList<>());
			outdegree.get(f[0]).add(new int[]{f[1], f[2]});
		}

		return dp(src, dst, k);
	}

	private int dp(int src, int dst, int k) {
		if (src == dst)
			return 0;

		if (k < 0)
			return -1;

		if (memo[src][k] == 0) {
			int min = Integer.MAX_VALUE;
			if (outdegree.containsKey(src)) {
				for (int[] v : outdegree.get(src)) {
					int to = v[0];
					int price = v[1];

					int subProblem = dp(to, dst, k - 1);
					if (subProblem != -1)
						min = Math.min(min, subProblem + price);
				}
			}
			memo[src][k] = min == Integer.MAX_VALUE ? -1 : min;
		}

		return memo[src][k];
	}
}
