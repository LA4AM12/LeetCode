package easy

// leetcode-0141 2021/4/5


func hasCycle(head *ListNode) bool {
	fast,slow := head,head
	for fast!= nil && fast.Next!=nil{
		fast = fast.Next.Next
		slow = slow.Next
		if fast == slow {
			return true
		}
	}
	return false
}