package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();
        backtrack(ans, path, n, k, 1);

        return ans;
    }

    public void backtrack(List<List<Integer>> ans, LinkedList<Integer> path, int n, int k, int start) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrack(ans, path, n, k, i+1);
            path.removeLast();
        }
    }
}
