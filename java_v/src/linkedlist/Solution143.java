package linkedlist;

import Offer.struct.ListNode;

/**
 * @author : LA4AM12
 * @create : 2021-10-31 11:09:27
 * @description : Reorder List
 */
public class Solution143 {
	public void reorderList(ListNode head) {
		ListNode middle = middleNode(head);
		ListNode head2 = reverseList(middle);

		mergeList(head,head2);
		middle.next = null;
	}

	private ListNode middleNode(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	private ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;

		return newHead;
	}

	private void mergeList(ListNode l1, ListNode l2){
		while (l1 != null && l2 != null){
			ListNode temp = l1.next;
			l1.next = l2;
			l1 = temp;
			temp = l2.next;
			l2.next = l1;
			l2 = temp;
		}
	}
}
