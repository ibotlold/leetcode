package main

// 110. Balanced Binary Tree
// https://leetcode.com/problems/balanced-binary-tree/description/

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

func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}
	_, ok := process(root)
	return ok
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}

func process(root *TreeNode) (int, bool) {
	if root == nil {
		return 0, true
	}
	left, ok := process(root.Left)
	if !ok {
		return 0, false
	}
	right, ok := process(root.Right)
	if !ok || abs(left-right) > 1 {
		return 0, false
	}
	return 1 + max(left, right), true
}
