package main

// 643. Maximum Average Subarray I
// https://leetcode.com/problems/maximum-average-subarray-i/

func findMaxAverage(nums []int, k int) float64 {
	if k == 1 {
		maxVal := nums[0]
		for i := 1; i < len(nums); i++ {
			maxVal = max(maxVal, nums[i])
		}
		return float64(maxVal)
	}

	var maxSum float64
	for i := 0; i < k; i++ {
		maxSum += float64(nums[i])
	}
	prevSum := maxSum
	for i := k; i < len(nums); i++ {
		l := nums[i-k]
		r := nums[i]
		sum := prevSum - float64(l) + float64(r)
		prevSum = sum
		maxSum = max(maxSum, sum)
	}

	return maxSum / float64(k)
}
