package dp;

public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%2 != 0) return false;

        //dp[i][j] indicates whether the backpack of capacity j can be filled for the first i items
        boolean[] dp = new boolean[sum/2+1];
        //base case  dp[...][0] = true
        dp[0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum/2; j > 0; j--) {
                if (j-nums[i-1] >= 0)
                    dp[j] |= dp[j-nums[i-1]];
            }
        }
        return dp[sum/2];
    }
}
