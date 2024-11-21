package main

import "slices"

// 56. Merge Intervals
// https://leetcode.com/problems/merge-intervals/

func merge(intervals [][]int) [][]int {
	slices.SortFunc(intervals, func(a []int, b []int) int {
		first := a[0]
		second := b[0]
		var result int
		if first > second {
			result = 1
		} else if first < second {
			result = -1
		}
		return result
	})
	var result [][]int
	handledSet := make(map[int]struct{})
	for k, interval := range intervals {
		if _, ok := handledSet[k]; ok {
			continue
		}
		start := interval[0]
		end := interval[1]
		for i := k + 1; i < len(intervals); i++ {
			if _, ok := handledSet[i]; ok {
				continue
			}
			current := intervals[i]
			isOverlap := current[0] <= end && current[1] >= start
			if isOverlap {
				start = min(start, current[0])
				end = max(end, current[1])
				handledSet[i] = struct{}{}
			}
		}
		result = append(result, []int{start, end})
		handledSet[k] = struct{}{}
	}

	return result
}
