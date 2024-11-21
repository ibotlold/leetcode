package main

import "strconv"

// 228. Summary Ranges
// https://leetcode.com/problems/summary-ranges/

func summaryRanges(nums []int) []string {
	var result []string
	var current string
	for i := 0; i < len(nums); i++ {
		var isRanged bool
		if current == "" {
			current += strconv.Itoa(nums[i])
		}
		for j := i + 1; j < len(nums); j++ {
			if nums[j]-nums[i] == 1 {
				isRanged = true
				i = j
				continue
			}
			i = j - 1
			if nums[j]-nums[j-1] > 1 {
				break
			}
		}
		if isRanged {
			current += "->"
			current += strconv.Itoa(nums[i])
		}
		result = append(result, current)
		current = ""
	}

	return result
}
