import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        new Solution().reverseVowels("Hello world!");
    }
}

class Solution {
    public String reverseVowels(String s) {
        int length = s.length();
        Deque<Character> vowels = new ArrayDeque<>(length / 2);
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                vowels.addFirst(ch);
            }
        }
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                ch = vowels.removeFirst();
            }
            builder.append(ch);
        }
        return builder.toString();
    }

    private boolean isVowel(char ch) {
        char lowerCaseChar = Character.toLowerCase(ch);
        if (lowerCaseChar == 'a') return true;
        if (lowerCaseChar == 'e') return true;
        if (lowerCaseChar == 'i') return true;
        if (lowerCaseChar == 'o') return true;
        if (lowerCaseChar == 'u') return true;
        return false;
    }
}