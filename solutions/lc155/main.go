package main

// 155. Min Stack
// https://leetcode.com/problems/min-stack/description/

type element struct {
	value int
	min   int
}

type MinStack struct {
	stack []element
}

func Constructor() MinStack {
	return MinStack{}
}

func (ms *MinStack) Push(val int) {
	elem := element{value: val, min: val}
	if len(ms.stack) > 0 {
		prev := ms.stack[len(ms.stack)-1]
		elem.min = min(prev.min, val)
	}
	ms.stack = append(ms.stack, elem)
}

func (ms *MinStack) Pop() {
	ms.stack = ms.stack[:len(ms.stack)-1]
}

func (ms *MinStack) Top() int {
	return ms.stack[len(ms.stack)-1].value
}

func (ms *MinStack) GetMin() int {
	return ms.stack[len(ms.stack)-1].min
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */
