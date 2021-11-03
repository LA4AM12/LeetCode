package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : LA4AM12
 * @create : 2021-11-03 20:07:06
 * @description : Minimum Window Substring
 */
public class Solution76 {
	public String minWindow(String s, String t) {
		Map<Character,Integer> wnd = new HashMap<>();
		Map<Character,Integer> need = new HashMap<>();

		String ans = "";
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < t.length(); i++) {
			Character c = t.charAt(i);
			need.put(c,need.getOrDefault(c,0)+1);
		}

		int left = 0, right = 0;
		int match = 0;

		while (right < s.length()) {
			Character c = s.charAt(right++);

			if (need.containsKey(c)){
				int times = wnd.getOrDefault(c,0)+1;
				wnd.put(c,times);

				if (times == need.get(c)){
					match++;
					if (match == need.size()){
						// move left
						while (true){
							c = s.charAt(left);
							left++;
							if (need.containsKey(c)) {
								times = wnd.get(c);
								wnd.put(c,times-1);
								if (times == need.get(c)){
									match--;
									if (right-left+1 < min){
										min = right-left+1;
										ans = s.substring(left-1,right);
									}

									break;
								}
							}
						}
					}
				}
			}
		}

		return ans;
	}
}
