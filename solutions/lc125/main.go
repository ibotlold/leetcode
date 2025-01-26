package main

import (
	"bytes"
)

// 125. Valid Palindrome
// https://leetcode.com/problems/valid-palindrome/

func isPalindrome(s string) bool {
	str := make([]byte, 0, len(s))
	for i := 0; i < len(s); i++ {
		ch := s[i]
		if isAlNum(ch) {
			str = append(str, toLower(ch))
		}
	}

	var l int
	r := len(str) - 1
	for l < r {
		if str[l] != str[r] {
			return false
		}
		l++
		r--
	}
	return true
}

func isAlNum(b byte) bool {
	res := 'a' <= b && b <= 'z'
	res = res || ('A' <= b && b <= 'Z')
	return res || ('0' <= b && b <= '9')
}

func toLower(b byte) byte {
	return bytes.ToLower([]byte{b})[0]
}
