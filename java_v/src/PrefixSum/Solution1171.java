package PrefixSum;

import Offer.struct.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : LA4AM12
 * @create : 2022-04-15 10:30:06
 * @description : Remove Zero Sum Consecutive Nodes from Linked List
 */
public class Solution1171 {
	public ListNode removeZeroSumSublists(ListNode head) {
		Map<Integer, ListNode> map = new HashMap<>();
		ListNode dummy = new ListNode(0, head);
		int sum = 0;
		for (ListNode pt = dummy; pt != null; pt = pt.next)
			map.put(sum += pt.val, pt); // record last node of same sum

		sum = 0;
		for (ListNode pt = dummy; pt != null; pt = pt.next)
			pt.next = map.get(sum += pt.val).next; // delete inter nodes
		return dummy.next;
	}
}
