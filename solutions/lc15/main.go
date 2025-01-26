package main

import "slices"

// 15. 3Sum
// https://leetcode.com/problems/3sum/

func threeSum(nums []int) [][]int {
	slices.Sort(nums)

	var ans [][]int
	for t := 0; t < len(nums)-2; t++ {
		l := t + 1
		r := len(nums) - 1

		for l < r {
			sum := nums[t] + nums[l] + nums[r]
			if sum == 0 {
				ans = append(ans, []int{nums[t], nums[l], nums[r]})
				l++
				for l < r {
					if nums[l] != nums[l-1] {
						break
					}
					l++
				}
				continue
			}
			if sum > 0 {
				r--
			} else {
				l++
			}
		}
		for i := t + 1; i < len(nums)-2; i++ {
			if nums[i] != nums[i-1] {
				break
			}
			t = i
		}
	}

	return ans
}
