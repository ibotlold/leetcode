package main

import "math"

// 1189. Maximum Number of Balloons
// https://leetcode.com/problems/maximum-number-of-balloons/

func maxNumberOfBalloons(text string) int {
	letters := make([]int, 26)
	for i := 0; i < len(text); i++ {
		idx := index(text[i])
		letters[idx]++
	}
	count := math.MaxInt
	count = min(count, letters[index('b')])
	count = min(count, letters[index('a')])
	count = min(count, letters[index('l')]/2)
	count = min(count, letters[index('o')]/2)
	count = min(count, letters[index('n')])

	return count
}

func index(c byte) int {
	return int(c - 'a')
}
