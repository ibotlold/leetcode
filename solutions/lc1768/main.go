package main

// 1768. Merge Strings Alternately
// https://leetcode.com/problems/merge-strings-alternately/description/

func mergeAlternately(word1 string, word2 string) string {
	lenSum := len(word1) + len(word2)
	result := make([]byte, lenSum)
	var first, second, current int
	for current != lenSum {
		if first < len(word1) {
			result[current] = word1[first]
			current++
			first++
		}
		if second < len(word2) {
			result[current] = word2[second]
			current++
			second++
		}
	}

	return string(result)
}
