package main

import "math"

// 121. Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

func maxProfit(prices []int) int {
	var profit int
	minVal := math.MaxInt
	for _, price := range prices {
		if price < minVal {
			minVal = price
		}
		profit = max(profit, price-minVal)
	}

	return profit
}
