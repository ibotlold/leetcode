import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
//        new Solution().longestPalindrome(new String[]{"lc","cl","gg"});
        new Solution().longestPalindrome(new String[]{"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"});
    }
}

class Solution {
    public int longestPalindrome(String[] words) {
        int length = 0;
        int[][] counter = new int[26][26];
        for (String word :
                words) {
            int a = word.charAt(0) - 'a';
            int b = word.charAt(1) - 'a';
            if (counter[b][a] > 0) {
                length += 4;
                counter[b][a]--;
            } else counter[a][b]++;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i][i] == 0) continue;
            length += 2;
            break;
        }

        return length;
    }
}