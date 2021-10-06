package medium

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
			for pt!=nil && pt.Val == v {
				pt = pt.Next
			}
			cur.Next = pt
		}else {
			cur = cur.Next
		}
	}
	return preHead.Next
}


//func deleteDuplicates(head *ListNode) *ListNode {
//	pre := &ListNode{Next: head}
//	cur := head
//	head = pre
//	for cur != nil && cur.Next != nil {
//		for cur.Next != nil && cur.Val == cur.Next.Val {
//			cur = cur.Next
//		}
//		if pre.Next != cur {
//			cur = cur.Next
//			pre.Next = cur
//		}else {
//			pre = cur
//			cur = cur.Next
//		}
//	}
//	return head.Next
//}