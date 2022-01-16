package greedy;


/**
 * @author : LA4AM12
 * @create : 2022-01-16 16:03:38
 * @description : Wiggle Subsequence
 */
public class Solution376 {
    // equivalent to finding the number of alternating max. and min. peaks in the array.
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;

        int prevDiff = nums[1] - nums[0];
        int ans = prevDiff == 0 ? 1 : 2;

        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (prevDiff >= 0 && diff < 0 || prevDiff <= 0 && diff > 0) {
                ans++;
                prevDiff = diff;
            }
        }

        return ans;
    }
}
