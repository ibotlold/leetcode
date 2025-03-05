package main

// 104. Maximum Depth of Binary Tree
// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

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
func maxDepth(root *TreeNode) int {
	var depth int
	var queue []*TreeNode
	if root == nil {
		return depth
	}
	queue = append(queue, root)

	for len(queue) > 0 {
		var childs []*TreeNode
		for _, elem := range queue {
			if elem == nil {
				continue
			}
			if elem.Left != nil {
				childs = append(childs, elem.Left)
			}
			if elem.Right != nil {
				childs = append(childs, elem.Right)
			}
		}

		depth++
		queue = childs
	}
	return depth
}
