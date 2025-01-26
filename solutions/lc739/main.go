package main

// 739. Daily Temperatures
// https://leetcode.com/problems/daily-temperatures/description/

func dailyTemperatures(temperatures []int) []int {
	if len(temperatures) == 1 {
		return []int{0}
	}
	ans := make([]int, len(temperatures))
	stack := []int{0}
	for i := 1; i < len(temperatures); i++ {
		for len(stack) > 0 {
			prevIdx := stack[len(stack)-1]
			prev := temperatures[prevIdx]
			if prev < temperatures[i] {
				ans[prevIdx] = i - prevIdx
				stack = stack[:len(stack)-1]
			} else {
				break
			}
		}
		stack = append(stack, i)
	}

	return ans
}
