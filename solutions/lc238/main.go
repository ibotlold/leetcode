package main

// 238. Product of Array Except Self
// https://leetcode.com/problems/product-of-array-except-self/

func productExceptSelf(nums []int) []int {
	n := len(nums)
	answer := make([]int, n)
	answer[0] = 1
	answer[n-1] = 1

	roll := 1
	for i := 1; i < n; i++ {
		roll *= nums[i-1]
		answer[i] = roll
	}
	roll = 1
	for i := n - 2; i >= 0; i-- {
		roll *= nums[i+1]
		answer[i] *= roll
	}
	return answer
}
