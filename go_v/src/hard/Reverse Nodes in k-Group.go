package hard

// leetcode-0025 2021/3/12

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseKGroup(head *ListNode, k int) *ListNode {
	end := head

	//反转一节链表的函数  返回新的头节点
	var reverse func(star, end *ListNode) *ListNode
	reverse = func(start, end *ListNode) *ListNode {
		pre, cur, next := start, start, start.Next
		for next != end {
			cur = next
			next = next.Next
			cur.Next = pre
			pre = cur
		}
		return cur
	}

	for i := 0; i < k; i++ {
		//base case
		if end == nil {
			return head
		} else {
			end = end.Next
		}
	}
	newHead := reverse(head, end)
	head.Next = reverseKGroup(end, k)
	return newHead
}
