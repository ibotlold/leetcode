package main

// 383. Ransom Note
// https://leetcode.com/problems/ransom-note/

func canConstruct(ransomNote string, magazine string) bool {
	letters := make([]int, 26)
	for i := 0; i < len(magazine); i++ {
		idx := index(magazine[i])
		letters[idx]++
	}
	for i := 0; i < len(ransomNote); i++ {
		idx := index(ransomNote[i])
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
