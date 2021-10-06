package Offer;

public class Solution19 {
    public boolean isMatch(String s, String p) {
        //dp[i][j]  s的前i个字符和p的前j个字符是否匹配

        int m = s.length();
        int n = p.length();

        // s 和 p 都可能为空
        boolean [][] dp = new boolean[m+1][n+1];

        //base case
        dp[0][0] = true;
        for (int i = 2; i <= n; i+=2) {
            dp[0][i] = dp[0][i-2] && p.charAt(i-1) == '*';
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // * 不会出现在开头
                if (p.charAt(j-1) == '*'){
                    //匹配0次
                    dp[i][j] = dp[i][j-2];
                    //匹配多次
                    if (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')
                        dp[i][j] |= dp[i-1][j];
                }
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                    dp[i][j] = dp[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}
