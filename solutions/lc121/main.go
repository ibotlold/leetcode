package main

// 121. Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

func maxProfit(prices []int) int {
	var sum int
	minVal := prices[0]
	for i := 1; i < len(prices); i++ {
		if prices[i] < minVal {
			minVal = prices[i]
		}
		sum = max(sum, prices[i]-minVal)
	}
	return sum
}
