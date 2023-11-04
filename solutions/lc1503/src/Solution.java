class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = 0;
        for (int i : right) {
            max = Math.max(max, n - i);
        }
        for (int i : left) {
            max = Math.max(max, i);
        }
        return max;
    }
}