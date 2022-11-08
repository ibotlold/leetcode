public class Main {
    public static void main(String[] args) {
//        new Solution().makeGood("leEeetcode");
        new Solution().makeGood("abBAcC");
    }
}

class Solution {
    public String makeGood(String s) {
        StringBuilder builder = new StringBuilder(s);
        boolean good = false;
        while (!good) {
            good = true;
            for (int i = 1; i < builder.length(); i++) {
                char a = builder.charAt(i - 1);
                char b = builder.charAt(i);
                if (Character.toLowerCase(a) == Character.toLowerCase(b)) {
                    if (a != b) {
                        builder.delete(i - 1, i + 1);
                        good = false;
                        break;
                    }
                }
            }
        }
        return builder.toString();
    }
}