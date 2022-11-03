import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (hashMap.containsKey(delta)) return new int[]{i, hashMap.get(delta)};
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }
}