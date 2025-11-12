package main

// 1436. Destination City
// https://leetcode.com/problems/destination-city/description/

func destCity(paths [][]string) string {
	m := make(map[string]bool)

	for _, p := range paths {
		m[p[0]] = true
	}

	for _, p := range paths {
		if v, ok := m[p[1]]; !ok {
			return p[1]
		}
	}

	return ""
}
