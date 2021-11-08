package backTracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2021-11-08 09:08:54
 * @description : Permutations
 */
public class Solution46 {
	private List<List<Integer>> ans = new ArrayList<>();
	private List<Integer> p ;
	private boolean[] flags;
	int len;

	public List<List<Integer>> permute(int[] nums) {
		len = nums.length;
		p = new ArrayList<>(len);
		flags = new boolean[len];
		tracing(nums,0);
		return ans;
	}

	private void tracing(int[] nums, int index) {
		if (index == len) {
			ans.add(new ArrayList<>(p));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!flags[i]) {
				p.add(nums[i]);
				flags[i] = true;
				tracing(nums,index+1);
				flags[i] = false;
				p.remove(index);
			}
		}
	}
}
