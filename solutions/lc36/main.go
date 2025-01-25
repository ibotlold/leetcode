package main

import "errors"

// 36. Valid Sudoku
// https://leetcode.com/problems/valid-sudoku/

type line []byte

func (l line) Add(ch byte) error {
	if ch == '.' {
		return nil
	}
	idx := index(ch)
	if l[idx] >= 1 {
		return errors.New("already exist")
	}
	l[idx]++

	return nil
}

func newLine() line {
	return make(line, 9)
}

func isValidSudoku(board [][]byte) bool {
	line := newLine()

	// row
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			err := line.Add(board[i][j])
			if err != nil {
				return false
			}
		}
		clear(line)
	}

	// column
	for j := 0; j < len(board[0]); j++ {
		for i := 0; i < len(board); i++ {
			err := line.Add(board[i][j])
			if err != nil {
				return false
			}
		}
		clear(line)
	}

	// sub box
	for iBox := 0; iBox < 3; iBox++ {
		for jBox := 0; jBox < 3; jBox++ {
			for i := iBox * 3; i < iBox*3+3; i++ {
				for j := jBox * 3; j < jBox*3+3; j++ {
					err := line.Add(board[i][j])
					if err != nil {
						return false
					}
				}
			}
			clear(line)
		}
	}

	return true
}

func index(c byte) int {
	return int(c - '1')
}
