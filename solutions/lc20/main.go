package main

import "container/list"

// 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/

func isValid(s string) bool {
	stack := list.New()
	stack.PushBack(s[0])
	for i := 1; i < len(s); i++ {
		ch := s[i]
		switch ch {
		case '(', '{', '[':
			stack.PushBack(ch)
		case ')', '}', ']':
			var cor byte
			switch ch {
			case ')':
				cor = '('
			case '}':
				cor = '{'
			case ']':
				cor = '['
			}
			top := stack.Back()
			if top == nil {
				return false
			}
			if top.Value.(byte) == cor {
				stack.Remove(stack.Back())
			} else {
				return false
			}
		}
	}
	return stack.Len() == 0
}
