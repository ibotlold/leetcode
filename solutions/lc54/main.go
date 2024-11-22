package main

// 54. Spiral Matrix
// https://leetcode.com/problems/spiral-matrix/

func spiralOrder(matrix [][]int) []int {
	rowCount := len(matrix)
	colCount := len(matrix[0])
	result := make([]int, rowCount*colCount)
	var resultCursor int
	collect := func(num int) {
		result[resultCursor] = num
		resultCursor++
	}
	top, right, bottom, left := 0, colCount-1, rowCount-1, 0
	for left <= right && top <= bottom {
		for i := left; i <= right; i++ {
			collect(matrix[top][i])
		}
		top++
		for i := top; i <= bottom; i++ {
			collect(matrix[i][right])
		}
		right--
		if top <= bottom {
			for i := right; i >= left; i-- {
				collect(matrix[bottom][i])
			}
			bottom--
		}
		if left <= right {
			for i := bottom; i >= top; i-- {
				collect(matrix[i][left])
			}
			left++
		}
	}

	return result
}
