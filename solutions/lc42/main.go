package main

// 42. Trapping Rain Water
// https://leetcode.com/problems/trapping-rain-water/

func trap(height []int) int {
	var sum int
	l, r := 0, len(height)-1
	lMax, rMax := 0, height[r]

	for l < r {
		if height[l] <= height[r] {
			if height[l] < lMax {
				sum += lMax - height[l]
			} else {
				lMax = height[l]
			}
			l++
		} else {
			if height[r] < rMax {
				sum += rMax - height[r]
			} else {
				rMax = height[r]
			}
			r--
		}
	}

	return sum
}
