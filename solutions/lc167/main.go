package main

// 167. Two Sum II - Input Array Is Sorted
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

func twoSum(numbers []int, target int) []int {
	a := 0
	b := len(numbers) - 1
	sum := numbers[a] + numbers[b]
	for sum != target {
		if sum > target {
			b--
		} else {
			a++
		}
		sum = numbers[a] + numbers[b]
	}

	return []int{a + 1, b + 1}
}
