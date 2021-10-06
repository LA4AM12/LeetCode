package dp;

public class Solution518 {
    public int change(int amount, int[] coins) {
        //dp[i][j]
        int[] dp = new int[amount+1];

        //base case  dp[...][0] = 1
        dp[0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j-coins[i-1] >= 0) {
                    dp[j] += dp[j-coins[i-1]];
                }
            }
        }

        return dp[amount];
    }
}
