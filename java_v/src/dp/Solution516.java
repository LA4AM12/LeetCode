package dp;

import java.util.Arrays;

public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[] dp = new int[len];

        //base case
        Arrays.fill(dp,1);

        for (int i = len-2; i >= 0 ; i--) {
            int pre = 0;
            for (int j = i+1; j < len; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j)){
                    dp[j] = pre + 2;
                }else {
                    dp[j] = Math.max(dp[j-1],dp[j]);
                }
                pre = temp;
                System.out.println(dp[j]);
            }
        }

        return dp[len-1];
    }
}
