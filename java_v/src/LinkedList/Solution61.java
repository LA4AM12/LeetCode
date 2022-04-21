package LinkedList;

import Offer.struct.ListNode;

/**
 * @author : LA4AM12
 * @create : 2022-04-21 11:01:10
 * @description : Rotate List
 */
public class Solution61 {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) return head;

		int n = 1;  // nums of the nodes
		ListNode pt = head;
		while (pt.next != null) {
			pt = pt.next;
			n++;
		}
		pt.next = head;
		int i = n - k % n;
		while (i-- > 0) {
			pt = pt.next;
		}
		head = pt.next;
		pt.next = null;
		return head;
	}
}
