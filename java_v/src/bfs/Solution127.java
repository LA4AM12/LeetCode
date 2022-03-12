package bfs;

import java.util.*;

/**
 * @author : LA4AM12
 * @create : 2022-03-12 10:10:42
 * @description : Word Ladder
 */
public class Solution127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);

		if (!wordSet.contains(endWord)) return 0;

		// 双端BFS
		Queue<String> queue1 = new LinkedList<>();
		queue1.offer(beginWord);
		Queue<String> queue2 = new LinkedList<>();
		queue2.offer(endWord);
		// 两端遍历过的节点
		Set<String> seen1 = new HashSet<>();
		seen1.add(beginWord);
		Set<String> seen2 = new HashSet<>();
		seen2.add(endWord);

		int ans = 1;
		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			ans++;
			// 选择节点少的一边进行遍历
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
					char c0 = s[i];
					for (char c = 'a'; c <= 'z'; c++) {
						s[i] = c;
						String next = new String(s);
						if (wordSet.contains(next) && !seen1.contains(next)) {
							// 产生交集
							if (seen2.contains(next))
								return ans;
							queue1.offer(next);
							seen1.add(next);
						}
					}
					s[i] = c0;
				}
			}
		}
		return 0;
	}
}
