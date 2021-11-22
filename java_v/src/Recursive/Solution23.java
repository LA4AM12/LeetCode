package Recursive;

import Offer.struct.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author : LA4AM12
 * @create : 2021-10-31 13:54:46
 * @description : Merge k Sorted Lists
 */
public class Solution23 {
	static class Entry implements Comparable<Entry>{
		ListNode node;
		int value;

		public Entry(ListNode node) {
			this.node = node;
			value = node.val;
		}

		@Override
		public int compareTo(Entry o) {
			return this.value-o.value;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		Queue<Entry> queue = new PriorityQueue<>();

		for (ListNode node : lists) {
			if (node != null)
				queue.offer(new Entry(node));
		}

		ListNode head = new ListNode(-1);
		ListNode tail = head;

		while (!queue.isEmpty()){
			Entry entry = queue.poll();
			tail.next = entry.node;
			tail = tail.next;
			if (entry.node.next != null)
				queue.offer(new Entry(entry.node.next));
		}

		return head.next;
	}
}
