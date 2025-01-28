package main

// 704. Binary Search
// https://leetcode.com/problems/binary-search/

func search(nums []int, target int) int {
	a, b := 0, len(nums)-1

	for a <= b {
		mid := (a + b) / 2
		if nums[mid] == target {
			return mid
		}
		if nums[mid] < target {
			a = mid + 1
		} else {
			b = mid - 1
		}
	}

	return -1
}
