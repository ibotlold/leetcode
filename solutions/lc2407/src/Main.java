import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int case1 = new Bruteforce().lengthOfLIS(new int[]{4, 2, 1, 4, 3, 4, 5, 8, 15}, 3);
    }
}
interface Solution {
    int lengthOfLIS(int[] nums, int k);
}
class Bruteforce implements Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int n = nums.length;
        int[] lisCache = new int[n];
        int result = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] &&
                        lisCache[i] < lisCache[j] + 1)
                    lisCache[i] = lisCache[j] + 1;
                    if (result < lisCache[i] + 1) result = lisCache[i] + 1;
            }
        }
        return result;
    }
}