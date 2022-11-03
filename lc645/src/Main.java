public class Main {
    public static void main(String[] args) {
        new Solution().findErrorNums(new int[]{1, 2, 2, 4});
//        new Solution().findErrorNums(new int[]{2, 2});
//        new Solution().findErrorNums(new int[]{1, 1});
    }
}

class Solution {
    public int[] findErrorNums(int[] nums) {
        int length = nums.length;
        if (length < 2) return new int[0];
        int[] contains = new int[length];
        int duplicate = -1;
        int lost = 0;
        for (int i = 0; i < length; i++) {
            contains[nums[i] - 1]++;
            if (contains[i] == 2) duplicate = i + 1;
            if (contains[i] == 0) lost = i + 1;
        }
        for (int i = 0; i < length; i++) {
            if (duplicate >= 0 && lost > 0) break;
        }
        return new int[]{duplicate,lost};
    }
}