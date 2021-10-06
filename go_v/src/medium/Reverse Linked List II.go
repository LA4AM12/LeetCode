package medium

// leetcode-0092 2021/3/11

type ListNode struct {
    Val int
    Next *ListNode
}

//通过递归来实现
func reverseBetween(head *ListNode, left int, right int) *ListNode {
   var successor *ListNode
   // 将链表的前 n 个节点反转（n <= 链表长度）
   var reverseN func(head *ListNode,n int) *ListNode
   reverseN = func(head *ListNode, n int) *ListNode {
       if n == 1 {
           successor = head.Next
           return head
       }
       last := reverseN(head.Next,n-1)
       head.Next.Next = head
       head.Next = successor
       return last
   }

   if left == 1 {
       return reverseN(head,right)
   }
   head.Next = reverseBetween(head.Next,left-1,right-1)
   return head
}

