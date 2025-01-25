package main

// 771. Jewels and Stones
// https://leetcode.com/problems/jewels-and-stones/description/

func numJewelsInStones(jewels string, stones string) int {
	set := make(map[byte]struct{})
	for i := 0; i < len(jewels); i++ {
		set[jewels[i]] = struct{}{}
	}

	var sum int
	for i := 0; i < len(stones); i++ {
		if _, ok := set[stones[i]]; ok {
			sum++
		}
	}

	return sum
}
