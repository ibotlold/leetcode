package main

// 238. Product of Array Except Self
// https://leetcode.com/problems/product-of-array-except-self/

func productExceptSelf(nums []int) []int {
	n := len(nums)
	answer := make([]int, n)
	postfix := make([]int, n)
	answer[0] = 1
	postfix[n-1] = 1

	prefixProduct := 1
	postfixProduct := 1
	for i := 1; i < n; i++ {
		prefixProduct *= nums[i-1]
		postfixProduct *= nums[n-i]
		answer[i] = prefixProduct
		postfix[n-i-1] = postfixProduct
	}
	for i := 0; i < n; i++ {
		answer[i] = answer[i] * postfix[i]
	}

	return answer
}
