package Offer;

import java.util.HashMap;
import java.util.Map;

class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        // Record the character and its last occurrence index
        Map<Character,Integer> dic = new HashMap<>();

        //Ensure that there are no duplicate characters in the index (i,j]
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if(dic.containsKey(c))
                i = Math.max(i, dic.get(c));
            dic.put(c, j);
            res = Math.max(res, j - i);
        }
        return res;
    }
}
