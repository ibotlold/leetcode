package main

// 13. Roman to Integer
// https://leetcode.com/problems/roman-to-integer

func romanToInt(s string) int {
	var sum, maxLast int
	for i := len(s) - 1; i >= 0; i-- {
		num := charToInt(s[i])
		if maxLast < num {
			maxLast = num
		}
		if num < maxLast {
			sum -= num
		} else {
			sum += num
		}
	}

	return sum
}

func charToInt(b byte) int {
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

	panic("No case")
}
