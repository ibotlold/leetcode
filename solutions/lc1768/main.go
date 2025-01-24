package main

import "strings"

// 1768. Merge Strings Alternately
// https://leetcode.com/problems/merge-strings-alternately/description/

func mergeAlternately(word1 string, word2 string) string {
	var buf strings.Builder

	var cursor int
	end := max(len(word1), len(word2))
	for cursor < end {
		if cursor < len(word1) {
			buf.WriteByte(word1[cursor])
		}
		if cursor < len(word2) {
			buf.WriteByte(word2[cursor])
		}
		cursor++
	}

	return buf.String()
}
