package LinkedList;

import Offer.struct.ListNode;

/**
 * @author : LA4AM12
 * @create : 2021-10-24 14:26:05
 * @description : Reverse Nodes in k-Group
 */
public class Solution25 {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode tail = head;
		for (int i = 0; i < k; i++) {
			if (tail == null)
				return head;
			tail = tail.next;
		}

		ListNode newHead = reverse(head, tail);
		head.next = reverseKGroup(tail, k);

		return newHead;
	}

	private ListNode reverse(ListNode start, ListNode end) {
		ListNode prev = null, pt = start;
		while (pt != end) {
			ListNode next = pt.next;
			pt.next = prev;
			prev = pt;
			pt = next;
		}
		return prev;
	}
}
