package main

// 54. Spiral Matrix
// https://leetcode.com/problems/spiral-matrix/

func spiralOrder(matrix [][]int) []int {
	ans := make([]int, 0, len(matrix)*len(matrix[0]))

	n, m := len(matrix), len(matrix[0])
	top, right, bottom, left := 0, m, n, 0
	for {
		var tick bool
		if top < bottom {
			for i := left; i < right; i++ {
				tick = true
				ans = append(ans, matrix[top][i])
			}
			top++
		}
		if left < right {
			for i := top; i < bottom; i++ {
				tick = true
				ans = append(ans, matrix[i][right-1])
			}
			right--
		}
		if top < bottom {
			for i := right - 1; i >= left; i-- {
				tick = true
				ans = append(ans, matrix[bottom-1][i])
			}
			bottom--
		}
		if left < right {
			for i := bottom - 1; i >= top; i-- {
				tick = true
				ans = append(ans, matrix[i][left])
			}
			left++
		}
		if !tick {
			break
		}
	}
	return ans
}
