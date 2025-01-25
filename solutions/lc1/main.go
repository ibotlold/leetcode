package main

// 1. Two Sum
// https://leetcode.com/problems/two-sum/

func twoSum(nums []int, target int) []int {
	seek := make(map[int]int)
	for i, v := range nums {
		if j, ok := seek[v]; ok {
			return []int{j, i}
		} else {
			seek[target-v] = i
		}
	}
	panic("no answer")
}
