package main

// 424. Longest Repeating Character Replacement
// https://leetcode.com/problems/longest-repeating-character-replacement/

func main() {
	characterReplacement("BAAAB", 2)
}

func characterReplacement(s string, k int) int {
	repl := make([]int, 27)

	var maxLen, l int
	maxFreqIdx := 26
	for r := 0; r < len(s); r++ {
		ch := s[r]
		chIdx := idx(ch)
		repl[chIdx]++
		count := repl[chIdx]
		if maxFreqIdx == 26 || repl[maxFreqIdx] < count {
			maxFreqIdx = chIdx
		}

		if r-l+1-repl[maxFreqIdx] > k {
			chIdx := idx(s[l])
			repl[chIdx]--
			l++
		}

		maxLen = max(maxLen, r-l+1)
	}
	return maxLen
}

func idx(c byte) int {
	return int(c - 'A')
}
