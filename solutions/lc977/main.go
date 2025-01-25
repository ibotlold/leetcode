package main

// 977. Squares of a Sorted Array
// https://leetcode.com/problems/squares-of-a-sorted-array/

func sortedSquares(nums []int) []int {
	a := 0
	b := len(nums) - 1
	i := b
	ans := make([]int, len(nums))
	for a <= b {
		if abs(nums[a]) > abs(nums[b]) {
			ans[i] = nums[a] * nums[a]
			a++
		} else {
			ans[i] = nums[b] * nums[b]
			b--
		}
		i--
	}

	return ans
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}
