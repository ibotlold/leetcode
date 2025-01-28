package main

// 19. Remove Nth Node From End of List
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

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

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	a := head
	b := head
	for i := 0; i < n; i++ {
		a = a.Next
	}

	if a == nil {
		return head.Next
	}

	for a.Next != nil {
		a = a.Next
		b = b.Next
	}
	el := b.Next
	b.Next = el.Next
	el.Next = nil

	return head
}
