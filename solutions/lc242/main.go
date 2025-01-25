package main

// 242. Valid Anagram
// https://leetcode.com/problems/valid-anagram/

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	letters := make([]int, 26)
	for i := 0; i < len(s); i++ {
		idx := index(s[i])
		letters[idx]++
	}
	for i := 0; i < len(t); i++ {
		idx := index(t[i])
		if letters[idx] <= 0 {
			return false
		}
		letters[idx]--
	}

	return true
}

func index(c byte) int {
	return int(c - 'a')
}
