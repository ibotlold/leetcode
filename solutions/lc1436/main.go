package main

// 1436. Destination City
// https://leetcode.com/problems/destination-city/description/

func destCity(paths [][]string) string {
	m := make(map[string]int)

	for _, p := range paths {
		m[p[0]] = m[p[0]] - 1
		m[p[1]] = m[p[1]] + 1
	}

	for k, i := range m {
		if i == 1 {
			return k
		}
	}

	return ""
}
