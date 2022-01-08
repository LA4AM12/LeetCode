package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2022-01-08 12:11:06
 * @description : Subsets II
 */
public class Solution90 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> sub = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, false);
        return ans;
    }

    private void backtrack(int[] nums, int cur, boolean choosePre) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(sub));
            return;
        }

        backtrack(nums, cur + 1, false);
        if (cur > 0 && nums[cur] == nums[cur - 1] && !choosePre)
            return;
        sub.add(nums[cur]);
        backtrack(nums, cur + 1, true);
        sub.removeLast();
    }
}
