public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    class Solution {
        public String removeDuplicates(String s) {
            StringBuilder stringBuilder = new StringBuilder(s);
            for (int i = 1; i < stringBuilder.length(); i++) {
                if (stringBuilder.length() < 2) break;
                if (i == 0) continue;
                if (stringBuilder.charAt(i) == stringBuilder.charAt(i - 1)) {
                    stringBuilder.delete(i - 1, i + 1);
                    i--;
                    i--;
                }
            }
            return stringBuilder.toString();
        }
    }
}