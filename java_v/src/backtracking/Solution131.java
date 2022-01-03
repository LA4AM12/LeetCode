package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2022-01-03 11:14:58
 * @description : Palindrome Partitioning
 */
public class Solution131 {
    private final List<List<String>> ans = new ArrayList<>();
    private final LinkedList<String> p = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return ans;
    }

    private void backtrack(String s, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(p));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String seg = s.substring(start, i);  // 截取一段
            if (!isPalindrome(seg)) continue;
            p.add(seg);
            backtrack(s, i);
            p.removeLast();
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}
