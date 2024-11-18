package main

// 13. Roman to Integer
// https://leetcode.com/problems/roman-to-integer

func romanToInt(s string) int {
	romanMap := map[string]int{
		"I":  1,
		"IV": 4,
		"V":  5,
		"IX": 9,
		"X":  10,
		"XL": 40,
		"L":  50,
		"XC": 90,
		"C":  100,
		"CD": 400,
		"D":  500,
		"CM": 900,
		"M":  1000,
	}

	var result, first, second int
	for first < len(s) {
		if first+1 < len(s) {
			second = first + 1
			val, ok := romanMap[s[first:second+1]]
			if ok {
				result += val
				first = second + 1
				continue
			}
		}
		result += romanMap[s[first:first+1]]
		first++
	}

	return result
}
