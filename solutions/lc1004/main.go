package main

// 1004. Max Consecutive Ones III
// https://leetcode.com/problems/max-consecutive-ones-iii/

func longestOnes(nums []int, k int) int {
	var i, j int
	for j = 0; j < len(nums); j++ {
		if nums[j] == 0 {
			k--
		}
		if k < 0 {
			i++
			if nums[i] == 0 {
				k++
			}
		}
	}

	return j - i
}
