package main

// 2239. Find Closest Number to Zero
// https://leetcode.com/problems/find-closest-number-to-zero/

func findClosestNumber(nums []int) int {
	answer := nums[0]
	for _, v := range nums {
		candidate := v
		if abs(answer) > abs(candidate) {
			answer = candidate
		} else if abs(answer) == abs(candidate) {
			if candidate > answer {
				answer = candidate
			}
		}
	}

	return answer
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
