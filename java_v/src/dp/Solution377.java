package dp;

/**
 * @author : LA4AM12
 * @create : 2022-02-19 17:45:52
 * @description : Combination Sum IV
 */
public class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
