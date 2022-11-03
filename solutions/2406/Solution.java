class Solution {
    public int minGroups(int[][] intervals) {
        int result = 1;
        int mask = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            int intersections = 0;
            for (int j = i + 1; j < intervals.length; j++) {
                if ((mask & (1 << i)) != 0) continue;
                if (intersect(intervals[i], intervals[j])) intersections++;
                mask = mask | (1 << i);
            }
            result = Math.max(result, intersections);
        }
        return result;
    }

    boolean intersect(int[] a, int[] b) {
        if (a[0] > b[1]) return false;
        if (a[1] < b[0]) return false;
        return true;
    }
}