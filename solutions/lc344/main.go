package main

// 344. Reverse String
// https://leetcode.com/problems/reverse-string/

func reverseString(s []byte) {
	for i := 0; i < len(s)/2; i++ {
		ch := s[i]
		s[i] = s[len(s)-i-1]
		s[len(s)-i-1] = ch
	}
}
