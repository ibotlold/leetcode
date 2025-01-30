package main

import "math"

// 367. Valid Perfect Square
// https://leetcode.com/problems/valid-perfect-square/

func isPerfectSquare(num int) bool {
	l, r := 1, math.MaxInt32
	for l <= r {
		mid := (l + r) / 2
		val := mid * mid
		if num == val {
			return true
		}
		if val < num {
			l = mid + 1
		} else {
			r = mid - 1
		}
	}

	return false
}
