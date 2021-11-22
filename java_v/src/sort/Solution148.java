package sort;

import Offer.struct.ListNode;

/**
 * @author : LA4AM12
 * @create : 2021-11-22 14:20:31
 * @description : Sort List
 */
public class Solution148 {
	public ListNode sortList(ListNode head) {
		return sortList(head, null);
	}

	private ListNode sortList(ListNode head, ListNode tail) {
		if (head == null)
			return null;
		if (head.next == tail) {
			head.next = null;
			return head;
		}

		//cut
		ListNode slow = head, fast = head;
		while (fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode l1 = sortList(head, slow);
		ListNode l2 = sortList(slow, tail);

		return merge(l1, l2);
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode pt = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				pt.next = l1;
				l1 = l1.next;
			} else {
				pt.next = l2;
				l2 = l2.next;
			}
			pt = pt.next;
		}

		if (l1 != null)
			pt.next = l1;
		if (l2 != null)
			pt.next = l2;

		return dummy.next;
	}
}
