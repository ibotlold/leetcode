package main

// 217. Contains Duplicate
// https://leetcode.com/problems/contains-duplicate/description/

func containsDuplicate(nums []int) bool {
	set := make(map[int]struct{}, int(len(nums)))
	for _, v := range nums {
		if _, ok := set[v]; ok {
			return true
		}
		set[v] = struct{}{}
	}

	return false
}
