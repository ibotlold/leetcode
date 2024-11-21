package main

import (
	"fmt"
)

// 228. Summary Ranges
// https://leetcode.com/problems/summary-ranges/

func summaryRanges(nums []int) []string {
	var result []string
	for start := 0; start < len(nums); start++ {
		end := start
		for i := start + 1; i < len(nums); i++ {
			if nums[i]-nums[i-1] != 1 {
				break
			}
			end = i
		}
		if start == end {
			result = append(result, fmt.Sprintf("%d", nums[start]))
		} else {
			result = append(result, fmt.Sprintf("%d->%d", nums[start], nums[end]))
		}
		start = end
	}

	return result
}
