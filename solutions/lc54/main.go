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

	left, top, right, bottom := 0, 0, colCount-1, rowCount-1
	x, y := 0, 0
	i, j := 1, 0
	goalX, goalY := right, 0
	for {
		collect(matrix[y][x])
		if x == goalX && y == goalY {
			i, j = nextDirection(i, j)
			if i != 0 && left >= right {
				break
			}
			if i == 1 {
				goalX = right
				left++
			} else if i == -1 {
				goalX = left
				right--
			}
			if j != 0 && top >= bottom {
				break
			}
			if j == 1 {
				goalY = bottom
				top++
			} else if j == -1 {
				goalY = top
				bottom--
			}
		}

		x += i
		y += j
	}

	return result
}

func nextDirection(i int, j int) (int, int) {
	if i == 1 && j == 0 {
		return 0, 1
	}
	if i == 0 && j == 1 {
		return -1, 0
	}
	if i == -1 && j == 0 {
		return 0, -1
	}
	return 1, 0
}
