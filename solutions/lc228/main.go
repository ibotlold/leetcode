package main

import (
	"fmt"
	"strconv"
)

// 228. Summary Ranges
// https://leetcode.com/problems/summary-ranges/

func summaryRanges(nums []int) []string {
	ans := make([]string, 0, len(nums))
	for i := 0; i < len(nums); i++ {
		start := i
		end := i
		current := nums[i]
		for j := i + 1; j < len(nums); j++ {
			last := nums[j-1]
			next := nums[j]
			delta := next - last
			if delta > 1 {
				break
			}
			end = j
		}
		count := end - start
		if count == 0 {
			ans = append(ans, strconv.Itoa(current))
		} else {
			ans = append(ans, fmt.Sprintf("%d->%d", current, nums[end]))
		}
		i = end
	}
	return ans
}
