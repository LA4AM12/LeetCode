package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : LA4AM12
 * @create : 2022-01-23 11:40:09
 * @description :
 */
public class Solution1105 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // sorted by abs
        nums = Arrays.stream(nums).boxed().sorted(Comparator.comparingInt(Math::abs)).mapToInt(Integer::intValue).toArray();

        // covert neg2pos in reverse order
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        if (k % 2 == 1) nums[0] = -nums[0];

        return Arrays.stream(nums).sum();
    }
}
