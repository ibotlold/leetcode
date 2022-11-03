public class Main {
    public static void main(String[] args) {
        new Solution().isPalindrome(123);
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        if (x % 10 == 0) return false;
        int cache = x;
        int reverseNum = 0;
        while (cache > 0) {
            int lastDigit = cache % 10;
            reverseNum = reverseNum * 10 + lastDigit;
            cache = cache / 10;
        }
        return x == reverseNum;
    }
}