package TowPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2021-11-20 11:26:07
 * @description : 3Sum
 */

public class Solution15 {
	public List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();

		// Remove duplicates by sorting
		Arrays.sort(nums);

		for (int fir = 0; fir < n - 2; fir++) {
			if (nums[fir] > 0) break;
			// Remove duplicates
			if (fir > 0 && nums[fir] == nums[fir - 1]) {
				continue;
			}

			// two pointers
			int snd = fir + 1, trd = n - 1;

			while (snd < trd) {
				// Remove duplicates
				if (snd > fir + 1 && nums[snd] == nums[snd - 1]) {
					snd++;
					continue;
				}
				int sum = nums[fir] + nums[snd] + nums[trd];

				if (sum < 0) {
					snd++;
				} else if (sum > 0) {
					trd--;
				} else {
					res.add(Arrays.asList(nums[fir], nums[snd++], nums[trd--]));
				}
			}
		}
		return res;
	}
}