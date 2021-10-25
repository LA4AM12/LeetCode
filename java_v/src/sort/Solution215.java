package sort;

/**
 * @author : LA4AM12
 * @create : 2021-10-25 15:09:04
 * @description : Kth Largest Element in an Array
 */
public class Solution215 {
	public int findKthLargest1(int[] nums, int k) {
		int len = nums.length;

		buildMinHeap(nums, k);

		for (int i = k; i < len; i++) {
			if (nums[i] > nums[0]){
				swap(nums,0,i);
				heapify(nums,0,k);
			}
		}

		return nums[0];
	}

	private void buildMinHeap(int[] a, int heapSize) {
		for (int i = heapSize / 2 - 1; i >= 0; i--) {
			heapify(a, i, heapSize);
		}
	}

	private void heapify(int[] a, int i, int heapSize) {
		int l = i * 2 + 1, r = l + 1, min = i;
		if (l < heapSize && a[l] < a[min])
			min = l;
		if (r < heapSize && a[r] < a[min])
			min = r;
		if (min != i){
			swap(a,i, min);
			heapify(a, min,heapSize);
		}
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// We can choose a random pivot to prevent the worst time complexity
	// like swap(a,0,randomIdx)
	public int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length - 1, nums.length - k);
	}

	private int quickSelect(int[] a, int l, int r, int index) {
		int pivot = a[l];
		int i = l, j = r;

		while (i < j) {
			while (i < j && a[j] >= pivot) j--;
			a[i] = a[j];
			while (i < j && a[i] < pivot) i++;
			a[j] = a[i];
		}

		a[i] = pivot;
		if (i > index) return quickSelect(a,l,i-1,index);
		if (i < index) return quickSelect(a,i+1,r,index);
		return pivot;
	}
}
