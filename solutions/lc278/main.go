package main

// 278. First Bad Version
// https://leetcode.com/problems/first-bad-version/

/**
 * Forward declaration of isBadVersion API.
 * @param   version   your guess about first bad version
 * @return 	 	      true if current version is bad
 *			          false if current version is good
 * func isBadVersion(version int) bool;
 */

func firstBadVersion(n int) int {
	l, r := 0, n
	for l <= r {
		mid := (l + r) / 2
		if isBadVersion(mid) {
			r = mid - 1
		} else {
			l = mid + 1
		}
	}

	return r
}
