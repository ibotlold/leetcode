package main

// 169. Majority Element
// https://leetcode.com/problems/majority-element/

func majorityElement(nums []int) int {
	m := make(map[int]int, len(nums)/2)
	for _, num := range nums {
		m[num]++
	}
	for k, v := range m {
		if v > len(nums)/2 {
			return k
		}
	}
	panic("no majority element")
}
