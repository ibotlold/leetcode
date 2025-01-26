package main

// 83. Remove Duplicates from Sorted List
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

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

func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil {
		return head
	}
	set := make(map[int]struct{})

	prev := head
	set[head.Val] = struct{}{}
	for e := head.Next; e != nil; e = e.Next {
		if _, ok := set[e.Val]; ok {
			prev.Next = e.Next
		} else {
			prev = e
			set[e.Val] = struct{}{}
		}
	}

	return head
}
