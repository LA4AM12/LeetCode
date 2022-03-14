package bfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : LA4AM12
 * @create : 2022-03-14 09:31:22
 * @description : Open the Lock
 */
public class Solution752 {
	public int openLock(String[] deadends, String target) {
		if (target.equals("0000")) return 0;
		Set<String> deadSet = Arrays.stream(deadends).collect(Collectors.toSet());
		if (deadSet.contains("0000")) return -1;

		Queue<String> queue1 = new LinkedList<>();
		queue1.offer("0000");
		Queue<String> queue2 = new LinkedList<>();
		queue2.offer(target);

		Set<String> seen1 = new HashSet<>();
		seen1.add("0000");
		Set<String> seen2 = new HashSet<>();
		seen2.add(target);

		int ans = 0;
		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			++ans;
			if (queue1.size() > queue2.size()) {
				Queue<String> temp = queue1;
				queue1 = queue2;
				queue2 = temp;
				Set<String> tmp = seen1;
				seen1 = seen2;
				seen2 = tmp;
			}
			int size = queue1.size();
			while (size-- > 0) {
				char[] s = queue1.poll().toCharArray();
				for (int i = 0; i < s.length; i++) {
					char origin = s[i];
					s[i] = origin == '0' ? '9' : (char) (origin - 1);
					String next = new String(s);
					if (!deadSet.contains(next) && !seen1.contains(next)) {
						if (seen2.contains(next)) {
							return ans;
						}
						seen1.add(next);
						queue1.offer(next);
					}
					s[i] = origin == '9' ? '0' : (char) (origin + 1);
					next = new String(s);
					if (!deadSet.contains(next) && !seen1.contains(next)) {
						if (seen2.contains(next)) {
							return ans;
						}
						seen1.add(next);
						queue1.offer(next);
					}
					s[i] = origin;
				}
			}
		}
		return -1;
	}
}
