package main

import "slices"

// 48. Rotate Image
// https://leetcode.com/problems/rotate-image/description/

func rotate(matrix [][]int) {
	for i := 0; i < len(matrix); i++ {
		for j := 0; j <= i; j++ {
			swap := matrix[i][j]
			matrix[i][j] = matrix[j][i]
			matrix[j][i] = swap
		}
	}
	for i := 0; i < len(matrix); i++ {
		slices.Reverse(matrix[i])
	}
}
