public class Solution {
    public int longestOnes(int[] nums, int k) {
//        [1,1,1,0,0,0,1,1,1,1,0]
//        [1,0,1,1,1,0,1,1,1,0,0,1,1,1,1,1,1,0,0,0,0,0]
        int firstOneIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                firstOneIndex = i;
                break;
            }
        }
        if (firstOneIndex == -1) return k;
        int switches = k;
        int left = Math.max(firstOneIndex - k, 0);
        int length = 0;
        int maxLength = 0;
        while (left < nums.length - 1){
            maxLength = Math.max(maxLength, length);
            if (left + length <= nums.length - 1 && (left + length - 1 < 0 || nums[left + length] == 1 || switches > 0)) {
                length++;
                if (nums[left + length - 1] == 0) switches--;
            } else {
                if (switches != k && nums[left] == 0) switches++;
                if (length > 0) length--;
                left++;
            }
        }

        return maxLength;
    }
}
