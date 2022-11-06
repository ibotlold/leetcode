import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
//        new Solution().orderlyQueue("cba", 1); //acb
//        new Solution().orderlyQueue("baaca", 3); // "aaabc"
//        new Solution().orderlyQueue("mpx", 3); // "mpx"
//        new Solution().orderlyQueue("gxvz", 2); // "gvxz"
//        new Solution().orderlyQueue("kuh", 1); // hku
        new Solution().orderlyQueue("enbczfjtvxerzbrvigpl", 1); // "bczfjtvxerzbrvigplen"
//        new Solution().orderlyQueue("xmvzi", 2); // imvxz

    }
}

class Solution {
    public String orderlyQueue(String s, int k) {
        if (s.length() == 1) return s;
        final int n = s.length();
        char[] charArray = new char[n];
        int minIndex = -1;
        char minChar = 'z';
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            charArray[i] = ch;
            if (ch == minChar) {
                for (int j = 1; j < n; j++) {
                    int aIndex = minIndex + j;
                    aIndex = aIndex - (aIndex / n) * n;
                    int bIndex = i + j;
                    bIndex = bIndex - (bIndex / n) * n;
                    char a = charArray[aIndex];
                    char b = s.charAt(bIndex);
                    if (a > b) {
                        minIndex = i;
                        break;
                    }
                    if (a < b) break;
                }
            }
            if (ch < minChar) {
                minChar = ch;
                minIndex = i;
            }
        }
        if (k >= 2) {
            Arrays.sort(charArray);
            return String.valueOf(charArray);
        }
        char[] minCharArray = new char[n];
        for (int i = 0; i < n; i++) {
            int index = i + minIndex;
            index = index - (index / n) * n;
            minCharArray[i] = charArray[index];
        }

        return String.valueOf(minCharArray);
    }
}

//class Solution {
//    public String orderlyQueue(String s, int k) {
//        if (s.length() == 1) return s;
//        final int n = s.length();
//        char[] charArray = s.toCharArray();
//        if (n == k) {
//            Arrays.sort(charArray);
//            return String.valueOf(charArray);
//        }
//        PriorityQueue<Character> queue = new PriorityQueue<>(k);
//        for (int i = 0; i < n - k + 1; i++) {
//            for (int j = i; j < i + k; j++) {
//                queue.offer(charArray[j]);
//            }
//            for (int j = i; j < i + k; j++) {
//                char newCh = queue.poll();
//                char oldCh = charArray[j];
//                charArray[j] = newCh;
//                if (newCh != oldCh) i--;
//            }
//        }
//
//        return String.valueOf(charArray);
//    }
//}
//
//    class Node {
//        int index;
//        char ch;
//        public Node(int index, char ch) {
//            this.index = index;
//            this.ch = ch;
//        }
//    }
//
//    private void move(char[] charArray, int index) {
//        if (index >= charArray.length - 1) return;
//        int cursor = 0;
//        char ch = charArray[index];
//        for (int i = 0; i < charArray.length; i++) {
//            if (i == index && i - cursor == 0) cursor++;
//            if (cursor == charArray.length) {
//                charArray[i] = ch;
//                break;
//            }
//            charArray[i] = charArray[cursor];
//            cursor++;
//        }
//    }
//}