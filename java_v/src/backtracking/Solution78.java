package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2021-12-04 09:57:14
 * @description : Subsets
 */
public class Solution78 {
	List<List<Integer>> ans;
	List<Integer> list;

	public List<List<Integer>> subsets(int[] nums) {
		ans = new ArrayList<>();
		list = new ArrayList<>();
		backtrack(nums, 0);
		return ans;
	}

	private void backtrack(int[] nums, int cur) {
		if (cur == nums.length) {
			ans.add(new ArrayList<>(list));
			return;
		}
		list.add(nums[cur]);
		backtrack(nums, cur + 1);
		list.remove(list.size() - 1);
		backtrack(nums, cur + 1);
	}
}
