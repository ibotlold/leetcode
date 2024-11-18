package main

import (
	"strings"
)

// 1768. Merge Strings Alternately
// https://leetcode.com/problems/merge-strings-alternately/description/

func mergeAlternately(word1 string, word2 string) string {
	first := strings.NewReader(word1)
	second := strings.NewReader(word2)
	var result strings.Builder
	result.Grow(len(word1) + len(word2))
	var flag bool = true
	for flag {
		ch1, size1, _ := first.ReadRune()
		if size1 > 0 {
			result.WriteRune(ch1)
		}
		ch2, size2, _ := second.ReadRune()
		if size2 > 0 {
			result.WriteRune(ch2)
		}
		if size1+size2 == 0 {
			flag = false
		}
	}

	return result.String()
}
