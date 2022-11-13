import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        new Solution().reverseWords("  Hello world!  ");
        new Solution().reverseWords("Hello world!");
    }
}

class Solution {
    public String reverseWords(String s) {
        StringBuilder reversedWords = new StringBuilder(s.length());
        Deque<Node> stack = new ArrayDeque<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (i - start != 0) stack.offer(new Node(start, i));
                start = i + 1;
            }
        }
        if (s.length() - start != 0) stack.offer(new Node(start, s.length()));
        while (stack.size() > 0) {
            Node word = stack.pollLast();
            for (int i = word.start; i < word.end; i++) {
                reversedWords.append(s.charAt(i));
            }
            if (stack.size() > 0) reversedWords.append(' ');
        }
        return reversedWords.toString();
    }

    record Node(int start, int end) {
    }
}