package main

import "slices"

// 13. Roman to Integer
// https://leetcode.com/problems/roman-to-integer

func romanToInt(s string) int {
	var backward = slices.Backward([]byte(s))
	var prev, sum int
	for _, v := range backward {
		val := letter(v)
		if prev > val {
			sum -= val
		} else {
			sum += val
		}
		prev = val
	}

	return sum
}

func letter(b byte) int {
	switch b {
	case 'I':
		return 1
	case 'V':
		return 5
	case 'X':
		return 10
	case 'L':
		return 50
	case 'C':
		return 100
	case 'D':
		return 500
	case 'M':
		return 1000
	}
	return 0
}
