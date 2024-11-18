package main

// 392. Is Subsequence
// https://leetcode.com/problems/is-subsequence/

func isSubsequence(s string, t string) bool {
	if len(s) == 0 {
		return true
	}
	if len(t) == 0 {
		return false
	}
	var cursor int
	for i := 0; i < len(t); i++ {
		if t[i] == s[cursor] {
			cursor++
		}
		if cursor == len(s) {
			return true
		}
	}

	return false
}
