package main

// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/description/

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

func reverseList(head *ListNode) *ListNode {
	var stack []int
	for e := head; e != nil; e = e.Next {
		stack = append(stack, e.Val)
	}
	for e := head; e != nil; e = e.Next {
		e.Val = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
	}

	return head
}
