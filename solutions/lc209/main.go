package main

import "math"

// 209. Minimum Size Subarray Sum
// https://leetcode.com/problems/minimum-size-subarray-sum/

func minSubArrayLen(target int, nums []int) int {
	var l, sum int
	minLen := math.MaxInt
	for r := 0; r < len(nums); r++ {
		sum += nums[r]

		for sum >= target {
			minLen = min(minLen, r-l+1)
			sum -= nums[l]
			l++
		}
	}

	if minLen == math.MaxInt {
		return 0
	}
	return minLen
}
