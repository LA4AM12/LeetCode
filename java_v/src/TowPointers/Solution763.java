package TowPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2022-01-24 17:15:59
 * @description : Partition Labels
 */
public class Solution763 {
    public List<Integer> partitionLabels(String s) {
        int[] lastAppear = new int[26];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            lastAppear[s.charAt(i) - 'a'] = i;
        }

        int left = -1, right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(lastAppear[s.charAt(i) - 'a'], right);
            if (right == i) {
                ans.add(right - left);
                left = right;
            }
        }
        return ans;
    }
}
