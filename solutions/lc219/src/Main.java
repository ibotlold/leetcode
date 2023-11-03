import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1,2,3,1},3));
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
//        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1,0,1,1},1));
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>(k + 1);
        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) {
                return true;
            }
            window.add(nums[i]);
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
}