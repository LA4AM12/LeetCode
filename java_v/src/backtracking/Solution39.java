package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2021-12-02 09:59:15
 * @description : Combination Sum
 */
public class Solution39 {
	List<List<Integer>> ans;
	List<Integer> list;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ans = new ArrayList<>();
		list = new ArrayList<>();
		backtrack(candidates, 0, 0, target);
		return ans;
	}

	private void backtrack(int[] candidates, int cur, int sum, int target) {
		if (sum > target) return;
		if (sum == target) {
			ans.add(new ArrayList<>(list));
			return;
		}

		for (int i = cur; i < candidates.length; i++) {
			list.add(candidates[i]);
			backtrack(candidates, i, sum + candidates[i], target);
			list.remove(list.size() - 1);
		}
	}
}
