package main

// 141. Linked List Cycle
// https://leetcode.com/problems/linked-list-cycle/

type ListNode struct {
	Val  int
	Next *ListNode
}

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func hasCycle(head *ListNode) bool {
	if head == nil {
		return false
	}
	a := head
	b := head
	for b != nil && b.Next != nil {
		a = a.Next
		b = b.Next.Next
		if a == b {
			return true
		}
	}
	return false
}
