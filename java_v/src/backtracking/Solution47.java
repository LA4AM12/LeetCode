package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2022-03-22 15:17:15
 * @description : Permutations II
 */
public class Solution47 {
	private List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		LinkedList<Integer> path = new LinkedList<>();
		boolean[] choose = new boolean[nums.length];
		Arrays.sort(nums);

		backtrack(nums, path, choose);
		return ans;
	}


	private void backtrack(int nums[], LinkedList<Integer> path, boolean[] choose) {
		if (path.size() == nums.length) {
			ans.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (choose[i] || i > 0 && nums[i] == nums[i - 1] && !choose[i - 1])
				continue;
			path.addLast(nums[i]);
			choose[i] = true;
			backtrack(nums, path, choose);
			choose[i] = false;
			path.removeLast();
		}
	}
}
