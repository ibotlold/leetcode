package main

import (
	"slices"
)

// 49. Group Anagrams
// https://leetcode.com/problems/group-anagrams/

func groupAnagrams(strs []string) [][]string {
	groups := make(map[string][]string)
	list := make([]byte, 0)
	for _, str := range strs {
		list = slices.Grow(list, len(str))

		for i := 0; i < len(str); i++ {
			list = append(list, str[i])
		}
		slices.Sort(list)
		title := string(list)
		grp := groups[title]
		grp = append(grp, str)
		groups[title] = grp

		list = list[:0]
	}

	ans := make([][]string, 0, len(groups))
	for _, grp := range groups {
		ans = append(ans, grp)
	}

	return ans
}
