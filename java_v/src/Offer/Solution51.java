package Offer;

//merge sort
public class Solution51 {
	private int[] nums, temp;

	public int reversePairs(int[] nums) {
		this.nums = nums;
		temp = new int[nums.length];
		return merge(0, nums.length-1);
	}

	private int merge(int l, int r) {
		if (l >= r) return 0;

		int mid = (l + r) >>> 1;
		int res = merge(l, mid) + merge(mid + 1, r);

		System.arraycopy(nums, l, temp, l, mid + 1 - l);

		int i = l, j = mid + 1, k = l;
		while (i <= mid && j <= r) {
			if (temp[i] <= nums[j]){
				nums[k++] = temp[i++];
			}else {
				res += mid-i+1;
				nums[k++] = nums[j++];
			}
		}
		while (i<=mid){
			nums[k++] = temp[i++];
		}
		return res;
	}
}
