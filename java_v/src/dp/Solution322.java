package dp;

import java.util.Arrays;

public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        //dp[i] denotes the minimum number of coins needed when the amount is i
        int[] dp = new int[amount+1];

        //amount+1 denotes infinity
        Arrays.fill(dp,amount+1);
        //base case
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == amount+1 ? -1 :dp[amount];
    }
}
