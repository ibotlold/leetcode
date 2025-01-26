package main

import (
	"container/list"
	"strconv"
)

// 682. Baseball Game
// https://leetcode.com/problems/baseball-game/description/

func calPoints(operations []string) int {
	stack := list.New()
	for _, ch := range operations {
		switch ch {
		case "+":
			top := stack.Back()
			sum := top.Value.(int) + top.Prev().Value.(int)
			stack.PushBack(sum)
		case "D":
			stack.PushBack(stack.Back().Value.(int) * 2)
		case "C":
			stack.Remove(stack.Back())
		default:
			x, err := strconv.Atoi(ch)
			if err != nil {
				panic("is not a number")
			}
			stack.PushBack(x)
		}
	}

	var sum int
	for e := stack.Front(); e != nil; e = e.Next() {
		sum += e.Value.(int)
	}

	return sum
}
