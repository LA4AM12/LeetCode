package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2022-01-02 22:06:57
 * @description : Letter Combinations of a Phone Number
 */
public class Solution17 {
    private final char[][] mapping = new char[][]{
            new char[]{},  // dummy
            new char[]{},
            new char[]{'a', 'b', 'c'},
            new char[]{'d', 'e', 'f'},
            new char[]{'g', 'h', 'i'},
            new char[]{'j', 'k', 'l'},
            new char[]{'m', 'n', 'o'},
            new char[]{'p', 'q', 'r', 's'},
            new char[]{'t', 'u', 'v'},
            new char[]{'w', 'x', 'y', 'z'}
    };
    private char[] seq;
    private final List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() > 0) {
            seq = new char[digits.length()];
            combine(digits, 0);
        }
        return ans;
    }

    public void combine(String digits, int cur) {
        if (cur == digits.length()) {
            ans.add(new String(seq));
            return;
        }
        for (char c : mapping[digits.charAt(cur) - '0']) {
            seq[cur] = c;
            combine(digits, cur + 1);
        }
    }
}
