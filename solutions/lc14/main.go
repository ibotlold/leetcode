package main

// 14. Longest Common Prefix
// https://leetcode.com/problems/longest-common-prefix/

func longestCommonPrefix(strs []string) string {
	var cursor = 0
	var first string = strs[0]
	var prefix string
	if len(first) < 1 {
		return prefix
	}
	list := strs[1:]
	for i := 0; i < len(first); i++ {
		isMatch := true
		for _, v := range list {
			if cursor >= len(v) {
				isMatch = false
				break
			}
			isMatch = first[cursor] == v[cursor]
			if !isMatch {
				break
			}
		}
		if !isMatch {
			break
		}
		cursor = i + 1
	}

	return first[0:cursor]
}
