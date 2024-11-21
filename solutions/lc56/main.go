package main

import (
	"sort"
)

// 56. Merge Intervals
// https://leetcode.com/problems/merge-intervals/

func merge(intervals [][]int) [][]int {
	sort.Slice(intervals, func(a int, b int) bool {
		return intervals[a][0] < intervals[b][0]
	})
	var result [][]int
	start, end := intervals[0][0], intervals[0][1]
	result = append(result, []int{start, end})

	for i := 1; i < len(intervals); i++ {
		currStart, currEnd := intervals[i][0], intervals[i][1]

		if currStart <= end {
			end = max(end, currEnd)
			result[len(result)-1][1] = end
		} else {
			start, end = currStart, currEnd
			result = append(result, []int{start, end})
		}
	}

	return result
}
