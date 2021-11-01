package TowPointers;

/**
 * @author : LA4AM12
 * @create : 2021-11-01 10:15:38
 * @description : Next Permutation
 */
public class Solution31 {
	public void nextPermutation(int[] nums) {

		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) i--;

		int j = nums.length - 1;
		if (i >= 0) {
			while (j > i && nums[j] <= nums[i]) j--;
			swap(nums, i, j);
		}

		for (i = i + 1, j = nums.length - 1; i < j; i++, j--) {
			swap(nums, i, j);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
}
