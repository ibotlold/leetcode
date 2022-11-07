public class Main {
    public static void main(String[] args) {
        new Solution().maximum69Number(6999);
    }
}

class Solution {
    public int maximum69Number (int num) {
        int cache = num;
        int lastSixPosition = -1;
        for (int i = 0; cache > 0; i++) {
            if (cache % 10 == 6) lastSixPosition = i;
            cache = cache / 10;
        }
        if (lastSixPosition == -1) return num;
        for (int i = 0; num > 0; i++) {
            int digit = num % 10;
            if (i == lastSixPosition) digit = 9;
            cache += digit * Math.pow(10, i);
            num = num / 10;
        }
        return cache;
    }
}