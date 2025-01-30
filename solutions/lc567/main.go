package main

import "slices"

// 567. Permutation in String
// https://leetcode.com/problems/permutation-in-string/

func main() {
	checkInclusion("ab", "cba")
}

func checkInclusion(s1 string, s2 string) bool {
	s1Freq := make([]byte, 26)
	s2Freq := make([]byte, 26)
	for i := 0; i < len(s1); i++ {
		idx := index(s1[i])
		s1Freq[idx]++
	}
	var l int
	for r := 0; r < len(s2); r++ {
		idx := index(s2[r])
		s2Freq[idx]++
		length := r - l + 1
		if len(s1) > length {
			continue
		}
		if len(s1) == length {
			res := slices.Compare(s1Freq, s2Freq)
			if res == 0 {
				return true
			}
		}
		idx = index(s2[l])
		s2Freq[idx]--
		l++
	}

	return false
}

func index(s byte) int {
	return int(s - 'a')
}
