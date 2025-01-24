package main

// 14. Longest Common Prefix
// https://leetcode.com/problems/longest-common-prefix/

func longestCommonPrefix(strs []string) string {
	var cur int
top:
	for {
		var ch byte
		for _, str := range strs {
			if cur == len(str) {
				break top
			}
			if ch == 0 {
				ch = str[cur]
				continue
			}
			if ch != str[cur] {
				break top
			}
		}
		cur++
	}

	return strs[0][:cur]
}
