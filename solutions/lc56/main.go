package main

import (
	"cmp"
	"slices"
)

// 56. Merge Intervals
// https://leetcode.com/problems/merge-intervals/

func merge(intervals [][]int) [][]int {
	ans := make([][]int, 0, len(intervals))
	slices.SortFunc(intervals, func(a, b []int) int {
		return cmp.Compare(a[0], b[0])
	})

	for i := 0; i < len(intervals); i++ {
		start, end := bounds(intervals[i])
		next := i
		for j := i + 1; j < len(intervals); j++ {
			nextStart, nextEnd := bounds(intervals[j])
			if nextStart <= end { // ??
				end = max(nextEnd, end)
				next = j
			} else {
				break
			}
		}
		ans = append(ans, []int{start, end})
		i = next
	}

	return ans
}

func bounds(interval []int) (start int, end int) {
	return interval[0], interval[1]
}
