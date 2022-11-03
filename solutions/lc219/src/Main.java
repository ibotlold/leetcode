import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1,2,3,1},3));
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
//        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1,0,1,1},1));
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 1) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) return true;
            }
        } else {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int number = nums[i];
                if (map.containsKey(number) && i - map.get(number) <= k) return true;
                map.put(number, i);
            }
        }
        return false;
    }
}