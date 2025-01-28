package main

// 138. Copy List with Random Pointer
// https://leetcode.com/problems/copy-list-with-random-pointer/

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Next *Node
 *     Random *Node
 * }
 */

func copyRandomList(head *Node) *Node {
	if head == nil {
		return nil
	}

	head = &Node{Next: head}
	res := &Node{}

	a := head
	b := res

	var stack []*Node
	m := make(map[*Node]*Node)
	for a.Next != nil {
		el := a.Next
		c := &Node{Val: el.Val}
		if el.Random != nil {
			stack = append(stack, el)
		}
		m[el] = c

		b.Next = c
		b = b.Next
		a = a.Next
	}

	for len(stack) != 0 {
		el := stack[len(stack)-1]
		c := m[el]
		c.Random = m[el.Random]

		stack = stack[:len(stack)-1]
	}

	return res.Next
}
