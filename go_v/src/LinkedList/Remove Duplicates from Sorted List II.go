package LinkedList

// leetcode-0082 2021/3/25

func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}

	preHead := &ListNode{Next: head}
	cur := preHead
	for cur.Next != nil && cur.Next.Next != nil {
		if cur.Next.Val == cur.Next.Next.Val {
			v := cur.Next.Val
			pt := cur.Next.Next.Next
			for pt != nil && pt.Val == v {
				pt = pt.Next
			}
			cur.Next = pt
		} else {
			cur = cur.Next
		}
	}
	return preHead.Next
}
