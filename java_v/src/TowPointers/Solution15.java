package TowPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
	public List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();

		// Remove duplicates by sorting
		Arrays.sort(nums);

		for (int fir = 0; fir < n-2; fir++) {
			if (nums[fir] > 0) break;
			// Remove duplicates
			if (fir > 0 && nums[fir] == nums[fir-1]){
				continue;
			}

			// two pointers
			int snd = fir + 1, trd = n - 1;

			while (snd < trd){
				// Remove duplicates
				if(snd > fir + 1 && nums[snd] == nums[snd - 1]){
					snd++;
					continue;
				}
				int sum = nums[fir] + nums[snd] + nums[trd];

				if(sum < 0){
					snd++;
				}else if (sum > 0){
					trd--;
				}else {
					List<Integer> list = new ArrayList<>();
					list.add(nums[fir]);
					list.add(nums[snd]);
					list.add(nums[trd]);
					res.add(list);
					snd++;
					trd--;
				}
			}

		}
		return res;
	}
}