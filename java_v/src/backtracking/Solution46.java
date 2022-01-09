package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : LA4AM12
 * @create : 2021-11-08 09:08:54
 * @description : Permutations
 */
public class Solution46 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backtrack(arr, 0);
        return ans;
    }

    private void backtrack(List<Integer> arr, int cur) {
        if (cur == arr.size()) {
            ans.add(new ArrayList<>(arr));
            return;
        }

        for (int i = cur; i < arr.size(); i++) {
            Collections.swap(arr, cur, i);
            backtrack(arr, cur + 1);
            // backtrack
            Collections.swap(arr, cur, i);
        }
    }
}
