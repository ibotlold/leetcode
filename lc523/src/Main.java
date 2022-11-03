import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        new Solution().checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6);
//        new Solution().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6);
//        new Solution().checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7);
//        new Solution().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13);
    }
}

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashSet<Integer> modSet = new HashSet<>();
        int currentSum = 0, prevSum = 0;
        for (int number :
                nums) {
            currentSum += number;
            currentSum %= k;
            if (modSet.contains(currentSum)) return true;
            modSet.add(prevSum);
            prevSum = currentSum;
        }
        return false;
    }
}