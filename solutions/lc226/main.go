package main

// 226. Invert Binary Tree
// https://leetcode.com/problems/invert-binary-tree/description/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func invertTree(root *TreeNode) *TreeNode {
	var queue []*TreeNode
	queue = append(queue, root)

	for len(queue) > 0 {
		elem := queue[len(queue)-1]
		queue = queue[:len(queue)-1]

		if elem == nil {
			continue
		}

		hand := elem.Left
		elem.Left = elem.Right
		elem.Right = hand

		queue = append(queue, elem.Left, elem.Right)
	}

	return root
}
