package main

// 238. Product of Array Except Self
// https://leetcode.com/problems/product-of-array-except-self/

func productExceptSelf(nums []int) []int {
	ans := make([]int, len(nums))

	var zeroCount int

	for _, v := range nums {
		if v == 0 {
			zeroCount++
		}
	}

	prod := 1
	if zeroCount > 1 {
		return ans
	} else if zeroCount == 1 {
		idx := -1
		for i, v := range nums {
			if v == 0 {
				idx = i
			} else {
				prod *= v
			}
		}
		ans[idx] = prod
		return ans
	}

	for i := 0; i < len(ans); i++ {
		ans[i] = 1
	}

	for i := 1; i < len(nums); i++ {
		prod *= nums[i-1]
		ans[i] = prod
	}
	prod = 1
	for i := len(nums) - 2; i >= 0; i-- {
		prod *= nums[i+1]
		ans[i] = ans[i] * prod
	}
	return ans
}
