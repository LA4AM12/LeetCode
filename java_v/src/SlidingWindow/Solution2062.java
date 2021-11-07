package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : LA4AM12
 * @create : 2021-11-07 10:32:57
 * @description : Count Vowel Substrings of a String
 */
public class Solution2062 {
	public int countVowelSubstrings(String word) {
		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');

		Map<Character, Integer> wnd = new HashMap();
		int l = 0, r;
		int ans = 0;

		while (l <= word.length() - 5) {
			Character c = word.charAt(l);

			if (vowels.contains(c)) {
				wnd.put(c, 1);
				r = l + 1;
				while (r < word.length()) {
					c = word.charAt(r++);
					if (!vowels.contains(c)) break;
					Integer times = wnd.getOrDefault(c, 0);
					wnd.put(c, times + 1);
					if (wnd.size() == 5)
						ans++;
				}
			}

			wnd.clear();
			l++;
		}

		return ans;
	}
}
