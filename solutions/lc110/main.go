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
	left := height(root.Left)
	right := height(root.Right)
	return abs(left-right) <= 1 && isBalanced(root.Left) && isBalanced(root.Right)
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}

func height(root *TreeNode) int {
	if root == nil {
		return 0
	}
	left := height(root.Left)
	right := height(root.Right)
	return 1 + max(left, right)
}
