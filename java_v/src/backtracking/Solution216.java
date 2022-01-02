package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2022-01-02 19:04:12
 * @description : Combination Sum III
 */
public class Solution216 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k,n,1,0);
        return ans;
    }

    private void backtrack(int k, int n, int cur, int sum) {
        // cut
        if (sum > n || list.size() + 10 - cur < k)
            return;

        if (list.size() == k) {
            if (sum == n)
                ans.add(new ArrayList<>(list));
            return;
        }

        list.add(cur);
        backtrack(k, n, cur + 1, sum + cur);
        list.removeLast();
        backtrack(k, n, cur + 1, sum);
    }
}
