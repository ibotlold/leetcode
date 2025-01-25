package main

// 128. Longest Consecutive Sequence
// https://leetcode.com/problems/longest-consecutive-sequence/
func longestConsecutive(nums []int) int {
	var maxSeq int
	set := make(map[int]struct{})

	for _, num := range nums {
		set[num] = struct{}{}
	}

	for k := range set {
		var count int
		if _, ok := set[k-1]; !ok {
			for {
				count++
				k++
				if _, ok := set[k]; !ok {
					break
				}
			}
			maxSeq = max(maxSeq, count)
		}
	}

	return maxSeq
}
