package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2021-11-15 12:25:10
 * @description : Restore IP Addresses
 */
public class Solution93 {
    List<String> ans = new ArrayList<>();
    String[] IP = new String[4];

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 0);
        return ans;
    }

    private void backtrack(String s, int cur, int seg) {
        // cut
        if (s.length() - cur < 4 - seg || s.length() - cur > 3 * (4 - seg))
            return;
        if (seg == 4) {
            ans.add(IP[0] + "." + IP[1] + "." + IP[2] + "." + IP[3]);
            return;
        }

        // 切割
        for (int i = 1; cur + i <= s.length(); i++) {
            IP[seg] = s.substring(cur, cur + i);
            // 不能存在前导0
            if (i != 1 && IP[seg].charAt(0) == '0')
                break;
            if (Integer.parseInt(IP[seg]) > 255)
                break;
            backtrack(s, cur + i, seg + 1);
        }
    }
}
