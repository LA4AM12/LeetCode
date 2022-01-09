package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2022-01-09 16:02:05
 * @description : Increasing Subsequences
 */
public class Solution491 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> sequence = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, Integer.MIN_VALUE, 0);
        return ans;
    }

    private void backtrack(int[] nums, int prev, int cur) {
        if (cur == nums.length) {
            if (sequence.size() > 1)
                ans.add(new ArrayList<>(sequence));
            return;
        }

        // choose
        if (nums[cur] >= prev) {
            sequence.add(nums[cur]);
            backtrack(nums, nums[cur], cur + 1);
            sequence.removeLast();
        }

        // 考虑重复的情况在于：对于两个相同的数，只选了其中一个
        // 限制选了前者 后者不能不选 即可去重
        if (nums[cur] != prev) {
            backtrack(nums, prev, cur + 1);
        }
    }
}
