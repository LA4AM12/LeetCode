package dp;

import java.lang.annotation.Target;

public class Solution494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum < Math.abs(target) || (sum + target) % 2 != 0) return 0;

        return subSets(nums, (sum + target) / 2);
    }
    //Convert to backpack problem

    /**
     * @return the nums of the ways to fill the backpack
     */
    private int subSets(int[] weight, int capacity) {
        int dp[] = new int[capacity + 1];

        //base case
        dp[0] = 1;

        for (int i = 1; i <= weight.length; i++) {
            for (int j = capacity; j >= 0; j--) {
                if (j >= weight[i - 1])
                    dp[j] += dp[j - weight[i - 1]];
            }
        }

        return dp[capacity];
    }
}
