package TowPointers

// leetcode-0234 2021/3/13

//空间复杂度达到O(1)
func isPalindrome(head *ListNode) bool {
	//翻转链表 返回新的头节点
	reverse := func(head *ListNode) *ListNode {
		var pre *ListNode
		cur := head
		for cur != nil {
			next := cur.Next
			cur.Next = pre
			pre = cur
			cur = next
		}
		return pre
	}

	//快慢指针
	fast, slow := head, head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	//对于奇数个结点的情况
	if fast != nil {
		slow = slow.Next
	}

	left, right := head, reverse(slow)
	for right != nil {
		if left.Val != right.Val {
			return false
		}
		left = left.Next
		right = right.Next
	}
	return true
}
