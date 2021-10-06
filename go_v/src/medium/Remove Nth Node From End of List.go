package medium

// leetcode-0019 2021/4/6

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	slow, fast := head, head
	for i := 0; i < n; i++ {
		fast = fast.Next
	}
	if fast == nil {
		return slow.Next
	}
	for fast.Next != nil {
		fast = fast.Next
		slow = slow.Next
	}
	slow.Next = slow.Next.Next
	return head
}
