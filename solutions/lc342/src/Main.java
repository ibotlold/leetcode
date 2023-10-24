class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        int mask = 1_431_655_765;
        int count = Integer.bitCount(n);
        return count == 1 && (n & mask) > 0;
    }
}