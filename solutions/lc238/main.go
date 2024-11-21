package main

// 238. Product of Array Except Self
// https://leetcode.com/problems/product-of-array-except-self/

func productExceptSelf(nums []int) []int {
	prefix := make([]int, len(nums))
	ball := 1
	prefix[0] = 1
	for i := 1; i < len(nums); i++ {
		prefix[i] = nums[i-1] * ball
		ball = prefix[i]
	}
	postfix := make([]int, len(nums))
	ball = 1
	postfix[len(nums)-1] = 1
	for i := len(nums) - 2; i >= 0; i-- {
		postfix[i] = nums[i+1] * ball
		ball = postfix[i]
	}
	result := make([]int, len(nums))
	for i := 0; i < len(result); i++ {
		result[i] = prefix[i] * postfix[i]
	}
	return result
}
