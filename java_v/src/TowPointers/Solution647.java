package TowPointers;

/**
 * @author : LA4AM12
 * @create : 2022-03-06 20:55:25
 * @description : Palindromic Substrings
 */
public class Solution647 {
	public int countSubstrings(String s) {
		int ans = 0, n = s.length();
		for (int i = 0; i < n; i++) {
			int left = i, right = i;
			while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
				ans++;
				left--;
				right++;
			}
			left = i; right = i + 1;
			while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
				ans++;
				left--;
				right++;
			}
		}
		return ans;
	}
}
