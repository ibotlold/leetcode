public class Main {
    public static void main(String[] args) {
        new Solution().removeDuplicates(new int[]{1,1,2});
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[k] == nums[i]) continue;
            k++;
            nums[k] = nums[i];
        }
        return k + 1;
    }
}