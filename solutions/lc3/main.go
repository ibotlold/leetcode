package main

// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

func main() {
	// lengthOfLongestSubstring("abccabcbb")
	// lengthOfLongestSubstring("bbbbbb")
	lengthOfLongestSubstring("aab")
}

func lengthOfLongestSubstring(s string) int {
	set := make(map[byte]struct{})
	var i, j, maxLen int
	for j = 0; j < len(s); j++ {
		if _, ok := set[s[j]]; ok {
			for i < j {
				if s[j] == s[i] {
					i++
					break
				}
				delete(set, s[i])
				i++
			}
		} else {
			set[s[j]] = struct{}{}
		}
		maxLen = max(maxLen, len(set))
	}

	return maxLen
}
