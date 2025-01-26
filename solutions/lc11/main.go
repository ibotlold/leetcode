package main

// 11. Container With Most Water
// https://leetcode.com/problems/container-with-most-water/

func maxArea(height []int) int {
	var maxArea int

	l := 0
	r := len(height) - 1
	for l < r {
		area := (r - l) * min(height[l], height[r])
		maxArea = max(maxArea, area)
		if height[l] > height[r] {
			r--
		} else {
			l++
		}
	}
	return maxArea
}
