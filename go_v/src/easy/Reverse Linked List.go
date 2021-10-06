package easy
// leetcode-0206 2021/3/11

type ListNode struct {
    Val int
    Next *ListNode
}

//递归
func reverseList(head *ListNode) *ListNode {
	if head == nil {
		return head
	}
	if head.Next == nil {
		return head
	}
	last := reverseList(head.Next)
	head.Next.Next = head
	head.Next = nil
	return last
}