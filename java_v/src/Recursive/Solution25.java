package Recursive;

import Offer.struct.ListNode;

/**
 * @author : LA4AM12
 * @create : 2021-10-24 14:26:05
 * @description : Reverse Nodes in k-Group
 */
public class Solution25 {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) return head;

		ListNode start, end;
		start = end = head;

		for (int i = 0; i < k; i++) {
			if (end != null)
				end = end.next;
			else
				return head;
		}

		ListNode newHead = reverse(start, end);

		start.next = reverseKGroup(end,k);

		return newHead;
	}

	private ListNode reverse(ListNode start, ListNode end) {
		ListNode pre = null;
		ListNode cur = start;

		while (cur != end){
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
