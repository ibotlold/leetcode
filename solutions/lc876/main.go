package main

// 876. Middle of the Linked List
// https://leetcode.com/problems/middle-of-the-linked-list/

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

func middleNode(head *ListNode) *ListNode {
	a := head
	b := head
	for b != nil && b.Next != nil {
		b = b.Next
		b = b.Next
		a = a.Next
	}

	return a
}
