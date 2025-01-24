package main

// 2239. Find Closest Number to Zero
// https://leetcode.com/problems/find-closest-number-to-zero/

func findClosestNumber(nums []int) int {
	answer := nums[0]
	for i := 1; i < len(nums); i++ {
		current := nums[i]
		if abs(current) < abs(answer) {
			answer = current
		} else if abs(answer) == abs(current) && current > answer {
			answer = current
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
