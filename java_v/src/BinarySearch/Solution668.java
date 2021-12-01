package BinarySearch;

/**
 * @author : LA4AM12
 * @create : 2021-12-01 20:09:22
 * @description :
 */
public class Solution668 {
	public int findKthNumber(int m, int n, int k) {
		int lo = 1, hi = m * n;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (enough(mid, m, n, k))
				hi = mid;
			else lo = mid + 1;
		}
		return lo;
	}

	// enough describes whether x is large enough to be the kth value in the multiplication table.
	private boolean enough(int x, int m, int n, int k) {
		int count = 0;
		for (int i = 1; i <= m; i++) {
			count += Math.min(x / i, n);
		}
		return count >= k;
	}
}
