package TowPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2021-10-26 15:50:59
 * @description : 3Sum
 */
public class Solution15 {
	public List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();

		// make nums[fir] <= nums[snd] <= nums[trd]
		Arrays.sort(nums);

		for (int fir = 0; fir < n-2; fir++) {
			if (fir > 0 && nums[fir] == nums[fir-1]){
				continue;
			}

			int snd = fir + 1;
			int trd = n - 1;

			while (snd < trd){
				if(snd > fir+1 && nums[snd] == nums[snd-1]){
					continue;
				}
			}

			for (int snd = fir + 1; snd < n-1; snd++) {
				if(snd > fir+1 && nums[snd] == nums[snd-1]){
					continue;
				}

				while (snd < trd && nums[fir] + nums[snd] + nums[trd] > 0){
					trd--;
				}

				if(snd == trd) break;

				if (nums[fir] + nums[snd] + nums[trd] == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[fir]);
					list.add(nums[snd]);
					list.add(nums[trd]);
					res.add(list);
				}
			}
		}
		return res;
	}
}
