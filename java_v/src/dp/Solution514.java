package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : LA4AM12
 * @create : 2021-10-14 10:35:00
 * @description : Freedom Trail
 */
public class Solution514 {
	private int[][] memo;
	private Map<Character, List<Integer>> map = new HashMap<>();
	private int len;
	public int findRotateSteps(String ring, String key) {
		len = ring.length();
		memo = new int[len][key.length()];
		for (int i = 0; i < len; i++) {
			Character c = ring.charAt(i);
			map.putIfAbsent(c, new ArrayList<>());
			map.get(c).add(i);
		}

		return dfs(key,0,0);
	}

	/**
	 *
	 * @param key target string for spelling
	 * @param cur index of the current character to be spelled
	 * @param pos index of the character has been aligned at the "12:00" direction
	 * @return the minimum number of steps to spell key[cur:]
	 */
	public int dfs(String key, int cur,int pos) {
		if (cur == key.length())
			return 0;
		if (memo[pos][cur] == 0){
			List<Integer> list = map.get(key.charAt(cur));
			int min = Integer.MAX_VALUE;
			for (Integer idx : list) {
				int step = Math.min(Math.abs(idx-pos),len - Math.abs(idx-pos));
				min = Math.min(dfs(key,cur+1,idx) + step + 1,min);
			}
			memo[pos][cur] = min;
		}

		return memo[pos][cur];
	}
}
