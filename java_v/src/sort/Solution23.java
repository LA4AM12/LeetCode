package sort;

import Offer.struct.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author : LA4AM12
 * @create : 2021-10-31 13:54:46
 * @description : Merge k Sorted Lists
 */
public class Solution23 {
	public ListNode mergeKLists(ListNode[] lists) {
		Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
		for (ListNode node : lists) {
			if (node != null)
				queue.offer(node);
		}

		ListNode dummy = new ListNode(-1);
		ListNode pt = dummy;

		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			pt.next = node;
			pt = node;
			if (node.next != null)
				queue.offer(node.next);
		}

		return dummy.next;
	}
}
