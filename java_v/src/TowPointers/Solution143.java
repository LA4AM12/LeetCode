package TowPointers;

import Offer.struct.ListNode;

/**
 * @author : LA4AM12
 * @create : 2021-10-31 11:09:27
 * @description : Reorder List
 */
public class Solution143 {
	public void reorderList(ListNode head) {
		ListNode head2 = reverse(middleNode(head));
		merge(head, head2);
	}

	private ListNode middleNode(ListNode head) {
		ListNode slow, fast;
		slow = fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	private ListNode reverse(ListNode head) {
		ListNode pre = null, cur = head;

		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}

		return pre;
	}

	private void merge(ListNode l1, ListNode l2) {
		ListNode pt1 = l1, pt2 = l2;

		while (pt2 != null && pt2.next != null) {
			ListNode next1 = pt1.next;
			ListNode next2 = pt2.next;
			pt1.next = pt2;
			pt2.next = next1;
			pt1 = next1;
			pt2 = next2;
		}
	}
}
