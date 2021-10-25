package Offer.struct;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author : LA4AM12
 * @create : 2021-10-25 14:56:27
 * @description : TOPK 类问题
 */
public class Solution40 {
	// 最大堆实现
	public int[] getLeastNumbers1(int[] arr, int k) {
		if (k == 0) {
			return new int[0];
		}
		// 使用一个最大堆（大顶堆）
		// Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
		Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

		for (int e : arr) {
			// 当前数字小于堆顶元素才会入堆
			if (heap.size() < k || e < heap.peek()) {
				heap.offer(e);
			}
			if (heap.size() > k) {
				heap.poll(); // 删除堆顶最大元素
			}
		}

		// 将堆中的元素存入数组
		int[] res = new int[k];
		int j = 0;
		for (int e : heap) {
			res[j++] = e;
		}
		return res;
	}

	// 快排思想实现
	public int[] getLeastNumbers(int[] arr, int k) {
		if (k >= arr.length) return arr;
		return quickSort(arr, k, 0, arr.length - 1);
	}

	private int[] quickSort(int[] arr, int k, int l, int r) {
		int i = l, j = r;
		int pivot = arr[l];

		while (i < j){
			while (i < j && arr[j] >= pivot) j--;
			arr[i] = arr[j];

			while (i < j && arr[i] < pivot) i++;
			arr[j] = arr[i];
		}

		arr[i] = pivot;

		if (i > k) return quickSort(arr,k,l,i-1);
		else if (i < k) return quickSort(arr,k,l+1,r);
		return Arrays.copyOf(arr,k);
	}


}
