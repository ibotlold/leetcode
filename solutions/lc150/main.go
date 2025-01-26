package main

import (
	"container/list"
	"strconv"
)

// 150. Evaluate Reverse Polish Notation
// https://leetcode.com/problems/evaluate-reverse-polish-notation/

func evalRPN(tokens []string) int {
	stack := list.New()
	for i := 0; i < len(tokens); i++ {
		ch := tokens[i]
		switch ch {
		case "+", "-", "*", "/":
			right := stack.Back()
			left := right.Prev()
			r := right.Value.(int)
			l := left.Value.(int)
			switch ch {
			case "+":
				left.Value = l + r
			case "-":
				left.Value = l - r
			case "*":
				left.Value = l * r
			case "/":
				left.Value = l / r
			}
			stack.Remove(right)
		default:
			num, _ := strconv.Atoi(ch)
			stack.PushBack(num)
		}
	}

	return stack.Back().Value.(int)
}
